package com.ruoyi.attendance.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.attendance.domain.DetectAttendanceSheet;
import com.ruoyi.attendance.service.IDetectAttendanceSheetService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 外检考勤Controller
 * 
 * @author yzw
 * @date 2022-12-25
 */
@RestController
@RequestMapping("/attendance/attendance")
public class DetectAttendanceSheetController extends BaseController
{
    @Autowired
    private IDetectAttendanceSheetService detectAttendanceSheetService;

    /**
     * 查询外检考勤列表
     */
    @PreAuthorize("@ss.hasPermi('attendance:attendance:list')")
    @GetMapping("/list")
    public TableDataInfo list(DetectAttendanceSheet detectAttendanceSheet)
    {
        startPage();
        List<DetectAttendanceSheet> list = detectAttendanceSheetService.selectDetectAttendanceSheetList(detectAttendanceSheet);
        return getDataTable(list);
    }

    /**
     * 导出外检考勤列表
     */
    @PreAuthorize("@ss.hasPermi('attendance:attendance:export')")
    @Log(title = "外检考勤", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DetectAttendanceSheet detectAttendanceSheet)
    {
        List<DetectAttendanceSheet> list = detectAttendanceSheetService.selectDetectAttendanceSheetList(detectAttendanceSheet);
        ExcelUtil<DetectAttendanceSheet> util = new ExcelUtil<DetectAttendanceSheet>(DetectAttendanceSheet.class);
        util.exportExcel(response, list, "外检考勤数据");
    }

    /**
     * 获取外检考勤详细信息
     */
    @PreAuthorize("@ss.hasPermi('attendance:attendance:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(detectAttendanceSheetService.selectDetectAttendanceSheetById(id));
    }

    /**
     * 新增外检考勤
     */
    @PreAuthorize("@ss.hasPermi('attendance:attendance:add')")
    @Log(title = "外检考勤", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DetectAttendanceSheet detectAttendanceSheet)
    {
        return toAjax(detectAttendanceSheetService.insertDetectAttendanceSheet(detectAttendanceSheet));
    }

    /**
     * 修改外检考勤
     */
    @PreAuthorize("@ss.hasPermi('attendance:attendance:edit')")
    @Log(title = "外检考勤", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DetectAttendanceSheet detectAttendanceSheet)
    {
        return toAjax(detectAttendanceSheetService.updateDetectAttendanceSheet(detectAttendanceSheet));
    }

    /**
     * 删除外检考勤
     */
    @PreAuthorize("@ss.hasPermi('attendance:attendance:remove')")
    @Log(title = "外检考勤", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(detectAttendanceSheetService.deleteDetectAttendanceSheetByIds(ids));
    }
}
