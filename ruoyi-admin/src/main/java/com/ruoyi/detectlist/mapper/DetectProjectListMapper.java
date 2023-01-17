package com.ruoyi.detectlist.mapper;

import java.util.List;
import com.ruoyi.detectlist.domain.DetectProjectList;

/**
 * 项目检测信息Mapper接口
 * 
 * @author Charlie
 * @date 2023-01-15
 */
public interface DetectProjectListMapper 
{
    /**
     * 查询项目检测信息
     * 
     * @param projectId 项目检测信息主键
     * @return 项目检测信息
     */
    public DetectProjectList selectDetectProjectListByProjectId(String projectId);

    /**
     * 查询项目检测信息列表
     * 
     * @param detectProjectList 项目检测信息
     * @return 项目检测信息集合
     */
    public List<DetectProjectList> selectDetectProjectListList(DetectProjectList detectProjectList);

    /**
     * 新增项目检测信息
     * 
     * @param detectProjectList 项目检测信息
     * @return 结果
     */
    public int insertDetectProjectList(DetectProjectList detectProjectList);

    /**
     * 修改项目检测信息
     * 
     * @param detectProjectList 项目检测信息
     * @return 结果
     */
    public int updateDetectProjectList(DetectProjectList detectProjectList);

    /**
     * 删除项目检测信息
     * 
     * @param projectId 项目检测信息主键
     * @return 结果
     */
    public int deleteDetectProjectListByProjectId(String projectId);

    /**
     * 批量删除项目检测信息
     * 
     * @param projectIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDetectProjectListByProjectIds(String[] projectIds);
}
