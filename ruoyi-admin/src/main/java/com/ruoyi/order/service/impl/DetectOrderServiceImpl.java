package com.ruoyi.order.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.order.mapper.DetectOrderMapper;
import com.ruoyi.order.domain.DetectOrder;
import com.ruoyi.order.service.IDetectOrderService;

/**
 * 委托信息Service业务层处理
 * 
 * @author yzw
 * @date 2023-04-05
 */
@Service
public class DetectOrderServiceImpl implements IDetectOrderService 
{
    @Autowired
    private DetectOrderMapper detectOrderMapper;

    /**
     * 查询委托信息
     * 
     * @param projectId 委托信息主键
     * @return 委托信息
     */
    @Override
    public DetectOrder selectDetectOrderByProjectId(String projectId)
    {
        return detectOrderMapper.selectDetectOrderByProjectId(projectId);
    }

    /**
     * 查询委托信息列表
     * 
     * @param detectOrder 委托信息
     * @return 委托信息
     */
    @Override
    public List<DetectOrder> selectDetectOrderList(DetectOrder detectOrder)
    {
        return detectOrderMapper.selectDetectOrderList(detectOrder);
    }

    /**
     * 新增委托信息
     * 
     * @param detectOrder 委托信息
     * @return 结果
     */
    @Override
    public int insertDetectOrder(DetectOrder detectOrder)
    {
        return detectOrderMapper.insertDetectOrder(detectOrder);
    }

    /**
     * 修改委托信息
     * 
     * @param detectOrder 委托信息
     * @return 结果
     */
    @Override
    public int updateDetectOrder(DetectOrder detectOrder)
    {
        return detectOrderMapper.updateDetectOrder(detectOrder);
    }

    /**
     * 批量删除委托信息
     * 
     * @param projectIds 需要删除的委托信息主键
     * @return 结果
     */
    @Override
    public int deleteDetectOrderByProjectIds(String[] projectIds)
    {
        return detectOrderMapper.deleteDetectOrderByProjectIds(projectIds);
    }

    /**
     * 删除委托信息信息
     * 
     * @param projectId 委托信息主键
     * @return 结果
     */
    @Override
    public int deleteDetectOrderByProjectId(String projectId)
    {
        return detectOrderMapper.deleteDetectOrderByProjectId(projectId);
    }
}
