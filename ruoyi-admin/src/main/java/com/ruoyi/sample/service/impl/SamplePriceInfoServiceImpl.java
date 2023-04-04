package com.ruoyi.sample.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sample.mapper.SamplePriceInfoMapper;
import com.ruoyi.sample.domain.SamplePriceInfo;
import com.ruoyi.sample.service.ISamplePriceInfoService;

/**
 * 样品价格Service业务层处理
 * 
 * @author charlie
 * @date 2023-04-04
 */
@Service
public class SamplePriceInfoServiceImpl implements ISamplePriceInfoService 
{
    @Autowired
    private SamplePriceInfoMapper samplePriceInfoMapper;

    /**
     * 查询样品价格
     * 
     * @param id 样品价格主键
     * @return 样品价格
     */
    @Override
    public SamplePriceInfo selectSamplePriceInfoById(String id)
    {
        return samplePriceInfoMapper.selectSamplePriceInfoById(id);
    }

    /**
     * 查询样品价格列表
     * 
     * @param samplePriceInfo 样品价格
     * @return 样品价格
     */
    @Override
    public List<SamplePriceInfo> selectSamplePriceInfoList(SamplePriceInfo samplePriceInfo)
    {
        return samplePriceInfoMapper.selectSamplePriceInfoList(samplePriceInfo);
    }

    /**
     * 新增样品价格
     * 
     * @param samplePriceInfo 样品价格
     * @return 结果
     */
    @Override
    public int insertSamplePriceInfo(SamplePriceInfo samplePriceInfo)
    {
        return samplePriceInfoMapper.insertSamplePriceInfo(samplePriceInfo);
    }

    /**
     * 修改样品价格
     * 
     * @param samplePriceInfo 样品价格
     * @return 结果
     */
    @Override
    public int updateSamplePriceInfo(SamplePriceInfo samplePriceInfo)
    {
        return samplePriceInfoMapper.updateSamplePriceInfo(samplePriceInfo);
    }

    /**
     * 批量删除样品价格
     * 
     * @param ids 需要删除的样品价格主键
     * @return 结果
     */
    @Override
    public int deleteSamplePriceInfoByIds(String[] ids)
    {
        return samplePriceInfoMapper.deleteSamplePriceInfoByIds(ids);
    }

    /**
     * 删除样品价格信息
     * 
     * @param id 样品价格主键
     * @return 结果
     */
    @Override
    public int deleteSamplePriceInfoById(String id)
    {
        return samplePriceInfoMapper.deleteSamplePriceInfoById(id);
    }
}
