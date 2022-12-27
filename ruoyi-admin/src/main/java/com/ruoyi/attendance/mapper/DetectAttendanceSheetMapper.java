package com.ruoyi.attendance.mapper;

import java.util.List;
import com.ruoyi.attendance.domain.DetectAttendanceSheet;

/**
 * 外检考勤Mapper接口
 * 
 * @author yzw
 * @date 2022-12-25
 */
public interface DetectAttendanceSheetMapper 
{
    /**
     * 查询外检考勤
     * 
     * @param id 外检考勤主键
     * @return 外检考勤
     */
    public DetectAttendanceSheet selectDetectAttendanceSheetById(Integer id);

    /**
     * 查询外检考勤列表
     * 
     * @param detectAttendanceSheet 外检考勤
     * @return 外检考勤集合
     */
    public List<DetectAttendanceSheet> selectDetectAttendanceSheetList(DetectAttendanceSheet detectAttendanceSheet);

    /**
     * 新增外检考勤
     * 
     * @param detectAttendanceSheet 外检考勤
     * @return 结果
     */
    public int insertDetectAttendanceSheet(DetectAttendanceSheet detectAttendanceSheet);

    /**
     * 修改外检考勤
     * 
     * @param detectAttendanceSheet 外检考勤
     * @return 结果
     */
    public int updateDetectAttendanceSheet(DetectAttendanceSheet detectAttendanceSheet);

    /**
     * 删除外检考勤
     * 
     * @param id 外检考勤主键
     * @return 结果
     */
    public int deleteDetectAttendanceSheetById(Integer id);

    /**
     * 批量删除外检考勤
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDetectAttendanceSheetByIds(Integer[] ids);
}
