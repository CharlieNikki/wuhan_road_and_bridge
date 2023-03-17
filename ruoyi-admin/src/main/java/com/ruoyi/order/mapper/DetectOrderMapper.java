package com.ruoyi.order.mapper;

import java.util.List;
import com.ruoyi.order.domain.DetectOrder;

/**
 * 委托单信息Mapper接口
 * 
 * @author yzw
 * @date 2023-03-16
 */
public interface DetectOrderMapper 
{
    /**
     * 查询委托单信息
     * 
     * @param projectId 委托单信息主键
     * @return 委托单信息
     */
    public DetectOrder selectDetectOrderByProjectId(String projectId);

    /**
     * 查询委托单信息列表
     * 
     * @param detectOrder 委托单信息
     * @return 委托单信息集合
     */
    public List<DetectOrder> selectDetectOrderList(DetectOrder detectOrder);

    /**
     * 新增委托单信息
     * 
     * @param detectOrder 委托单信息
     * @return 结果
     */
    public int insertDetectOrder(DetectOrder detectOrder);

    /**
     * 修改委托单信息
     * 
     * @param detectOrder 委托单信息
     * @return 结果
     */
    public int updateDetectOrder(DetectOrder detectOrder);

    /**
     * 删除委托单信息
     * 
     * @param projectId 委托单信息主键
     * @return 结果
     */
    public int deleteDetectOrderByProjectId(String projectId);

    /**
     * 批量删除委托单信息
     * 
     * @param projectIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDetectOrderByProjectIds(String[] projectIds);
}
