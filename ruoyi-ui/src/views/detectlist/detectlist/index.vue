<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="工程名称" prop="projectName">
        <el-input
          v-model="queryParams.projectName"
          placeholder="请输入工程名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="负责人/用户" prop="username">
        <el-input
          v-model="queryParams.username"
          placeholder="请输入负责人/用户"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系电话" prop="telephone">
        <el-input
          v-model="queryParams.telephone"
          placeholder="请输入联系电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="申请日期" prop="date">
        <el-input
          v-model="queryParams.date"
          placeholder="请输入申请日期"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="审批状态" prop="datastatus">
        <el-input
          v-model="queryParams.datastatus"
          placeholder="请输入审批状态"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['detectlist:detectlist:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['detectlist:detectlist:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['detectlist:detectlist:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['detectlist:detectlist:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="detectlistList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="工程名称" align="center" prop="projectName" />
      <el-table-column label="负责人/用户" align="center" prop="username" />
      <el-table-column label="联系电话" align="center" prop="telephone" />
      <el-table-column label="详细内容" align="center" prop="content" />
      <el-table-column label="申请日期" align="center" prop="date" />
      <el-table-column label="审批状态" align="center" prop="datastatus" />
      <el-table-column label="工程编号" align="center" prop="projectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['detectlist:detectlist:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['detectlist:detectlist:remove']"
          >删除</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-paperclip"
            @click="handleApproval(scope.row)"
            v-hasPermi="['detectlist:detectlist:remove']"
          >审批受理</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改项目检测信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="工程名称" prop="projectName">
          <el-input v-model="form.projectName" placeholder="请输入工程名称" />
        </el-form-item>
        <el-form-item label="负责人/用户" prop="username">
          <el-input v-model="form.username" placeholder="请输入负责人/用户" />
        </el-form-item>
        <el-form-item label="联系电话" prop="telephone">
          <el-input v-model="form.telephone" placeholder="请输入联系电话" />
        </el-form-item>
        <el-form-item label="详细内容">
          <editor v-model="form.content" :min-height="192"/>
        </el-form-item>
        <el-form-item label="申请日期" prop="date">
          <el-input v-model="form.date" placeholder="请输入申请日期" />
        </el-form-item>
        <el-form-item label="审批状态" prop="datastatus">
          <el-input v-model="form.datastatus" placeholder="请输入审批状态" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listDetectlist,
  getDetectlist,
  delDetectlist,
  addDetectlist,
  updateDetectlist,
  approvalDetect
} from "@/api/detectlist/detectlist";

export default {
  name: "Detectlist",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 项目检测信息表格数据
      detectlistList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        projectName: null,
        username: null,
        telephone: null,
        content: null,
        date: null,
        datastatus: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        datastatus: [
          { required: true, message: "审批状态不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询项目检测信息列表 */
    getList() {
      this.loading = true;
      listDetectlist(this.queryParams).then(response => {
        this.detectlistList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        projectName: null,
        username: null,
        telephone: null,
        content: null,
        date: null,
        datastatus: null,
        projectId: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.projectId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加项目检测信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const projectId = row.projectId || this.ids
      getDetectlist(projectId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改项目检测信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.projectId != null) {
            updateDetectlist(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDetectlist(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const projectIds = row.projectId || this.ids;
      this.$modal.confirm('是否确认删除项目检测信息编号为"' + projectIds + '"的数据项？').then(function() {
        return delDetectlist(projectIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('detectlist/detectlist/export', {
        ...this.queryParams
      }, `detectlist_${new Date().getTime()}.xlsx`)
    },
    /** 审批按钮操作 */
    handleApproval(row) {
      const projectId = row.projectId || this.ids;
      this.$modal.confirm('是否确认审批编号为"' + projectId + '"的工程？').then(function() {
        return approvalDetect(projectId);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("申请已受理");
      }).catch(() => {});
    }
  }
};
</script>
