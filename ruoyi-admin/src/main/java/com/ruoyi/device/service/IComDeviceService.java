package com.ruoyi.device.service;

import java.util.List;
import com.ruoyi.device.domain.ComDevice;

/**
 * 公司设备信息管理Service接口
 * 
 * @author yzw
 * @date 2023-02-22
 */
public interface IComDeviceService 
{
    /**
     * 查询公司设备信息管理
     * 
     * @param id 公司设备信息管理主键
     * @return 公司设备信息管理
     */
    public ComDevice selectComDeviceById(String id);

    /**
     * 查询公司设备信息管理列表
     * 
     * @param comDevice 公司设备信息管理
     * @return 公司设备信息管理集合
     */
    public List<ComDevice> selectComDeviceList(ComDevice comDevice);

    /**
     * 新增公司设备信息管理
     * 
     * @param comDevice 公司设备信息管理
     * @return 结果
     */
    public int insertComDevice(ComDevice comDevice);

    /**
     * 修改公司设备信息管理
     * 
     * @param comDevice 公司设备信息管理
     * @return 结果
     */
    public int updateComDevice(ComDevice comDevice);

    /**
     * 批量删除公司设备信息管理
     * 
     * @param ids 需要删除的公司设备信息管理主键集合
     * @return 结果
     */
    public int deleteComDeviceByIds(String[] ids);

    /**
     * 删除公司设备信息管理信息
     * 
     * @param id 公司设备信息管理主键
     * @return 结果
     */
    public int deleteComDeviceById(String id);
}
