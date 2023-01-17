package com.ruoyi.detectlist.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目检测信息对象 detect_project_list
 * 
 * @author Charlie
 * @date 2023-01-15
 */
public class DetectProjectList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工程名称 */
    @Excel(name = "工程名称")
    private String projectName;

    /** 负责人/用户 */
    @Excel(name = "负责人/用户")
    private String username;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String telephone;

    /** 详细内容 */
    @Excel(name = "详细内容")
    private String content;

    /** 申请日期 */
    @Excel(name = "申请日期")
    private String date;

    /** 审批状态 */
    @Excel(name = "审批状态")
    private String datastatus;

    /** 工程编号 */
    private String projectId;

    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setDate(String date) 
    {
        this.date = date;
    }

    public String getDate() 
    {
        return date;
    }
    public void setDatastatus(String datastatus) 
    {
        this.datastatus = datastatus;
    }

    public String getDatastatus() 
    {
        return datastatus;
    }
    public void setProjectId(String projectId) 
    {
        this.projectId = projectId;
    }

    public String getProjectId() 
    {
        return projectId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("projectName", getProjectName())
            .append("username", getUsername())
            .append("telephone", getTelephone())
            .append("content", getContent())
            .append("date", getDate())
            .append("datastatus", getDatastatus())
            .append("projectId", getProjectId())
            .toString();
    }
}
