package com.ruoyi.sample.service;

import java.util.List;
import com.ruoyi.sample.domain.SamplePriceInfo;

/**
 * 样品价格Service接口
 * 
 * @author charlie
 * @date 2023-04-04
 */
public interface ISamplePriceInfoService 
{
    /**
     * 查询样品价格
     * 
     * @param id 样品价格主键
     * @return 样品价格
     */
    public SamplePriceInfo selectSamplePriceInfoById(String id);

    /**
     * 查询样品价格列表
     * 
     * @param samplePriceInfo 样品价格
     * @return 样品价格集合
     */
    public List<SamplePriceInfo> selectSamplePriceInfoList(SamplePriceInfo samplePriceInfo);

    /**
     * 新增样品价格
     * 
     * @param samplePriceInfo 样品价格
     * @return 结果
     */
    public int insertSamplePriceInfo(SamplePriceInfo samplePriceInfo);

    /**
     * 修改样品价格
     * 
     * @param samplePriceInfo 样品价格
     * @return 结果
     */
    public int updateSamplePriceInfo(SamplePriceInfo samplePriceInfo);

    /**
     * 批量删除样品价格
     * 
     * @param ids 需要删除的样品价格主键集合
     * @return 结果
     */
    public int deleteSamplePriceInfoByIds(String[] ids);

    /**
     * 删除样品价格信息
     * 
     * @param id 样品价格主键
     * @return 结果
     */
    public int deleteSamplePriceInfoById(String id);
}
