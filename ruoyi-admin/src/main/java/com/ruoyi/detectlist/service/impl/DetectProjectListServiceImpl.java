package com.ruoyi.detectlist.service.impl;

import java.util.List;

import com.ruoyi.detectlist.mapper.DetectProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.detectlist.mapper.DetectProjectListMapper;
import com.ruoyi.detectlist.domain.DetectProjectList;
import com.ruoyi.detectlist.service.DetectProjectListService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 项目检测信息Service业务层处理
 *
 * @author Charlie
 * @date 2023-01-15
 */
@Service
public class DetectProjectListServiceImpl implements DetectProjectListService
{
    @Autowired
    private DetectProjectListMapper detectProjectListMapper;

    @Autowired
    private DetectProjectMapper detectProjectMapper;
    /**
     * 查询项目检测信息
     *
     * @param projectId 项目检测信息主键
     * @return 项目检测信息
     */
    @Override
    public DetectProjectList selectDetectProjectListByProjectId(String projectId)
    {
        return detectProjectListMapper.selectDetectProjectListByProjectId(projectId);
    }

    /**
     * 查询项目检测信息列表
     *
     * @param detectProjectList 项目检测信息
     * @return 项目检测信息
     */
    @Override
    public List<DetectProjectList> selectDetectProjectListList(DetectProjectList detectProjectList)
    {
        return detectProjectListMapper.selectDetectProjectListList(detectProjectList);
    }

    /**
     * 新增项目检测信息
     *
     * @param detectProjectList 项目检测信息
     * @return 结果
     */
    @Override
    public int insertDetectProjectList(DetectProjectList detectProjectList)
    {
        return detectProjectListMapper.insertDetectProjectList(detectProjectList);
    }

    /**
     * 修改项目检测信息
     *
     * @param detectProjectList 项目检测信息
     * @return 结果
     */
    @Override
    public int updateDetectProjectList(DetectProjectList detectProjectList)
    {
        return detectProjectListMapper.updateDetectProjectList(detectProjectList);
    }

    /**
     * 批量删除项目检测信息
     *
     * @param projectIds 需要删除的项目检测信息主键
     * @return 结果
     */
    @Override
    public int deleteDetectProjectListByProjectIds(String[] projectIds)
    {
        return detectProjectListMapper.deleteDetectProjectListByProjectIds(projectIds);
    }

    /**
     * 删除项目检测信息信息
     *
     * @param projectId 项目检测信息主键
     * @return 结果
     */
    @Override
    public int deleteDetectProjectListByProjectId(String projectId)
    {
        return detectProjectListMapper.deleteDetectProjectListByProjectId(projectId);
    }

    /**
     * 审批项目申请信息
     * @param projectId 项目检测信息主键
     * @return 结果
     */
    @Override
    @Transactional
    public boolean approvalDetectProjectByProjectId(String projectId) {

        // 1. 更改DetectProject中的data_status
        detectProjectMapper.updateProjectDataStatusByProjectId(projectId, 1);
        // 2. 更改DetectProjectList中的dataStatus
        detectProjectListMapper.approvalDetectProjectByProjectId(projectId);

        return true;
    }
}
