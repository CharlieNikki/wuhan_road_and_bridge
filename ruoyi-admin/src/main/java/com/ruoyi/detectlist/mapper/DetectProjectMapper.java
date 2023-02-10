package com.ruoyi.detectlist.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * detect_request表
 */
@Mapper
public interface DetectProjectMapper {

    /**
     * 更改申请项目的审批状态
     */
    int updateProjectDataStatusByProjectId(@Param("projectId") String projectId, @Param("dataStatus") int dataStatus);
}
