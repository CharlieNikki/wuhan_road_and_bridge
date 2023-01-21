package com.ruoyi.detectlist.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DetectProjectMapper {

    /**
     * 更改申请项目的审批状态
     */
    int updateProjectDataStatusByProjectId(String projectId, int dataStatus);
}
