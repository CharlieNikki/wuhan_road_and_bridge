package com.ruoyi.attendance.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.attendance.mapper.DetectAttendanceSheetMapper;
import com.ruoyi.attendance.domain.DetectAttendanceSheet;
import com.ruoyi.attendance.service.IDetectAttendanceSheetService;

/**
 * 外检考勤Service业务层处理
 * 
 * @author yzw
 * @date 2022-12-27
 */
@Service
public class DetectAttendanceSheetServiceImpl implements IDetectAttendanceSheetService 
{
    @Autowired
    private DetectAttendanceSheetMapper detectAttendanceSheetMapper;

    /**
     * 查询外检考勤
     * 
     * @param id 外检考勤主键
     * @return 外检考勤
     */
    @Override
    public DetectAttendanceSheet selectDetectAttendanceSheetById(Integer id)
    {
        return detectAttendanceSheetMapper.selectDetectAttendanceSheetById(id);
    }

    /**
     * 查询外检考勤列表
     * 
     * @param detectAttendanceSheet 外检考勤
     * @return 外检考勤
     */
    @Override
    public List<DetectAttendanceSheet> selectDetectAttendanceSheetList(DetectAttendanceSheet detectAttendanceSheet)
    {
        return detectAttendanceSheetMapper.selectDetectAttendanceSheetList(detectAttendanceSheet);
    }

    /**
     * 新增外检考勤
     * 
     * @param detectAttendanceSheet 外检考勤
     * @return 结果
     */
    @Override
    public int insertDetectAttendanceSheet(DetectAttendanceSheet detectAttendanceSheet)
    {
        return detectAttendanceSheetMapper.insertDetectAttendanceSheet(detectAttendanceSheet);
    }

    /**
     * 修改外检考勤
     * 
     * @param detectAttendanceSheet 外检考勤
     * @return 结果
     */
    @Override
    public int updateDetectAttendanceSheet(DetectAttendanceSheet detectAttendanceSheet)
    {
        return detectAttendanceSheetMapper.updateDetectAttendanceSheet(detectAttendanceSheet);
    }

    /**
     * 批量删除外检考勤
     * 
     * @param ids 需要删除的外检考勤主键
     * @return 结果
     */
    @Override
    public int deleteDetectAttendanceSheetByIds(Integer[] ids)
    {
        return detectAttendanceSheetMapper.deleteDetectAttendanceSheetByIds(ids);
    }

    /**
     * 删除外检考勤信息
     * 
     * @param id 外检考勤主键
     * @return 结果
     */
    @Override
    public int deleteDetectAttendanceSheetById(Integer id)
    {
        return detectAttendanceSheetMapper.deleteDetectAttendanceSheetById(id);
    }
}
