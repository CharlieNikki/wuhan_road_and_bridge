package com.ruoyi.order.service.impl;

import java.util.List;

import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.order.mapper.DetectOrderMapper;
import com.ruoyi.order.domain.DetectOrder;
import com.ruoyi.order.service.IDetectOrderService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 委托单信息Service业务层处理
 *
 * @author yzw
 * @date 2023-03-16
 */
@Service
public class DetectOrderServiceImpl implements IDetectOrderService
{
    @Autowired
    private DetectOrderMapper detectOrderMapper;

    /**
     * 查询委托单信息
     *
     * @param projectId 委托单信息主键
     * @return 委托单信息
     */
    @Override
    public DetectOrder selectDetectOrderByProjectId(String projectId)
    {
        return detectOrderMapper.selectDetectOrderByProjectId(projectId);
    }

    /**
     * 查询委托单信息列表
     *
     * @param detectOrder 委托单信息
     * @return 委托单信息
     */
    @Override
    public List<DetectOrder> selectDetectOrderList(DetectOrder detectOrder)
    {
        return detectOrderMapper.selectDetectOrderList(detectOrder);
    }

    /**
     * 新增委托单信息
     *
     * @param detectOrder 委托单信息
     * @return 结果
     */
    @Override
    public int insertDetectOrder(DetectOrder detectOrder)
    {
        return detectOrderMapper.insertDetectOrder(detectOrder);
    }

    /**
     * 修改委托单信息
     *
     * @param detectOrder 委托单信息
     * @return 结果
     */
    @Override
    public int updateDetectOrder(DetectOrder detectOrder)
    {
        return detectOrderMapper.updateDetectOrder(detectOrder);
    }

    /**
     * 批量删除委托单信息
     *
     * @param projectIds 需要删除的委托单信息主键
     * @return 结果
     */
    @Override
    public int deleteDetectOrderByProjectIds(String[] projectIds)
    {
        return detectOrderMapper.deleteDetectOrderByProjectIds(projectIds);
    }

    /**
     * 删除委托单信息信息
     *
     * @param projectId 委托单信息主键
     * @return 结果
     */
    @Override
    public int deleteDetectOrderByProjectId(String projectId)
    {
        return detectOrderMapper.deleteDetectOrderByProjectId(projectId);
    }

    /**
     * 导入用户数据
     * @param detectOrderList 数据列表
     * @param isUpdateSupport 是否支持更新，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     * @throws Exception
     */
    @Override
    @Transactional
    public String importData(List<DetectOrder> detectOrderList, Boolean isUpdateSupport, String operName) throws Exception {

        if (StringUtils.isNull(detectOrderList) || detectOrderList.size() == 0) {
            throw new Exception("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        List<DetectOrder> existList = selectDetectOrderList(null);
        for (DetectOrder importData : detectOrderList) {
            try {
                boolean userFlag = false;
                for (DetectOrder entry : existList) {
                    if (entry.getProjectId().equals(importData.getProjectId())) {
                        userFlag = true;
                        break;
                    }
                }
                if (!userFlag) {
                    insertDetectOrder(importData);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、数据" + importData.getProjectId() + "导入成功");
                } else if (isUpdateSupport) {
                    updateDetectOrder(importData);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、数据" + importData.getProjectId() + "更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、数据" + importData.getProjectId() + "已存在");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号" + importData.getProjectId() + "导入失败";
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "导入失败！共" + failureNum + "条数据格式不正确，错误信息如下：");
            throw new Exception(failureMsg.toString());
        } else {
            successMsg.insert(0, "数据已全部导入，共" + successNum + "条，数据如下：");
        }
        return successMsg.toString();
    }
}
