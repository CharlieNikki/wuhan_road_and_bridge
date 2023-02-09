package com.ruoyi.detectlist.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.detectlist.domain.DetectProjectList;
import com.ruoyi.detectlist.service.DetectProjectListService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目检测信息Controller
 *
 * @author Charlie
 * @date 2023-01-15
 */
@RestController
@RequestMapping("/detectlist/detectlist")
public class DetectProjectListController extends BaseController
{
    @Autowired
    private DetectProjectListService detectProjectListService;

    /**
     * 查询项目检测信息列表
     */
    @PreAuthorize("@ss.hasPermi('detectlist:detectlist:list')")
    @GetMapping("/list")
    public TableDataInfo list(DetectProjectList detectProjectList)
    {
        startPage();
        List<DetectProjectList> list = detectProjectListService.selectDetectProjectListList(detectProjectList);
        return getDataTable(list);
    }

    /**
     * 导出项目检测信息列表
     */
    @PreAuthorize("@ss.hasPermi('detectlist:detectlist:export')")
    @Log(title = "项目检测信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DetectProjectList detectProjectList)
    {
        List<DetectProjectList> list = detectProjectListService.selectDetectProjectListList(detectProjectList);
        ExcelUtil<DetectProjectList> util = new ExcelUtil<DetectProjectList>(DetectProjectList.class);
        util.exportExcel(response, list, "项目检测信息数据");
    }

    /**
     * 获取项目检测信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('detectlist:detectlist:query')")
    @GetMapping(value = "/{projectId}")
    public AjaxResult getInfo(@PathVariable("projectId") String projectId)
    {
        return AjaxResult.success(detectProjectListService.selectDetectProjectListByProjectId(projectId));
    }

    /**
     * 新增项目检测信息
     */
    @PreAuthorize("@ss.hasPermi('detectlist:detectlist:add')")
    @Log(title = "项目检测信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DetectProjectList detectProjectList)
    {
        return toAjax(detectProjectListService.insertDetectProjectList(detectProjectList));
    }

    /**
     * 修改项目检测信息
     */
    @PreAuthorize("@ss.hasPermi('detectlist:detectlist:edit')")
    @Log(title = "项目检测信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DetectProjectList detectProjectList)
    {
        return toAjax(detectProjectListService.updateDetectProjectList(detectProjectList));
    }

    /**
     * 删除项目检测信息
     */
    @PreAuthorize("@ss.hasPermi('detectlist:detectlist:remove')")
    @Log(title = "项目检测信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{projectIds}")
    public AjaxResult remove(@PathVariable String[] projectIds)
    {
        return toAjax(detectProjectListService.deleteDetectProjectListByProjectIds(projectIds));
    }

    /**
     * 审批项目申请
     */
    @PreAuthorize("@ss.hasAnyPermi('detectlist:detectlist:list')")
    @Log(title = "审批项目申请", businessType = BusinessType.OTHER)
    @PutMapping("/{projectId}")
    public AjaxResult approval(@PathVariable String projectId) {

        // 成功修改两张表的数据
        // 返回ajax数据
        return toAjax(detectProjectListService.approvalDetectProjectByProjectId(projectId));
    }
}
