package com.ruoyi.device.service.impl;

import java.util.List;

import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.device.mapper.ComDeviceMapper;
import com.ruoyi.device.domain.ComDevice;
import com.ruoyi.device.service.IComDeviceService;

/**
 * 公司设备信息管理Service业务层处理
 * 
 * @author yzw
 * @date 2023-02-22
 */
@Service
public class ComDeviceServiceImpl implements IComDeviceService 
{
    @Autowired
    private ComDeviceMapper comDeviceMapper;

    /**
     * 查询公司设备信息管理
     * 
     * @param id 公司设备信息管理主键
     * @return 公司设备信息管理
     */
    @Override
    public ComDevice selectComDeviceById(String id)
    {
        return comDeviceMapper.selectComDeviceById(id);
    }

    /**
     * 查询公司设备信息管理列表
     * 
     * @param comDevice 公司设备信息管理
     * @return 公司设备信息管理
     */
    @Override
    public List<ComDevice> selectComDeviceList(ComDevice comDevice)
    {
        return comDeviceMapper.selectComDeviceList(comDevice);
    }

    /**
     * 新增公司设备信息管理
     * 
     * @param comDevice 公司设备信息管理
     * @return 结果
     */
    @Override
    public int insertComDevice(ComDevice comDevice)
    {
        return comDeviceMapper.insertComDevice(comDevice);
    }

    /**
     * 修改公司设备信息管理
     * 
     * @param comDevice 公司设备信息管理
     * @return 结果
     */
    @Override
    public int updateComDevice(ComDevice comDevice)
    {
        return comDeviceMapper.updateComDevice(comDevice);
    }

    /**
     * 批量删除公司设备信息管理
     * 
     * @param ids 需要删除的公司设备信息管理主键
     * @return 结果
     */
    @Override
    public int deleteComDeviceByIds(String[] ids)
    {
        return comDeviceMapper.deleteComDeviceByIds(ids);
    }

    /**
     * 删除公司设备信息管理信息
     * 
     * @param id 公司设备信息管理主键
     * @return 结果
     */
    @Override
    public int deleteComDeviceById(String id)
    {
        return comDeviceMapper.deleteComDeviceById(id);
    }
}
