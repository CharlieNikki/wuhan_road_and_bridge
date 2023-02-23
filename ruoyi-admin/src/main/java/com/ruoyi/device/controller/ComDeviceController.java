package com.ruoyi.device.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.ServletUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.device.domain.ComDevice;
import com.ruoyi.device.service.IComDeviceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 公司设备信息管理Controller
 * 
 * @author yzw
 * @date 2023-02-22
 */
@RestController
@RequestMapping("/device/device")
public class    ComDeviceController extends BaseController
{
    @Autowired
    private IComDeviceService comDeviceService;

    /**
     * 查询公司设备信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('device:device:list')")
    @GetMapping("/list")
    public TableDataInfo list(ComDevice comDevice)
    {
        startPage();
        List<ComDevice> list = comDeviceService.selectComDeviceList(comDevice);
        return getDataTable(list);
    }

    /**
     * 导出公司设备信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('device:device:export')")
    @Log(title = "公司设备信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ComDevice comDevice)
    {
        List<ComDevice> list = comDeviceService.selectComDeviceList(comDevice);
        ExcelUtil<ComDevice> util = new ExcelUtil<ComDevice>(ComDevice.class);
        util.exportExcel(response, list, "公司设备信息管理数据");
    }

    /**
     * 获取公司设备信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('device:device:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(comDeviceService.selectComDeviceById(id));
    }

    /**
     * 新增公司设备信息管理
     */
    @PreAuthorize("@ss.hasPermi('device:device:add')")
    @Log(title = "公司设备信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ComDevice comDevice)
    {
        return toAjax(comDeviceService.insertComDevice(comDevice));
    }

    /**
     * 修改公司设备信息管理
     */
    @PreAuthorize("@ss.hasPermi('device:device:edit')")
    @Log(title = "公司设备信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ComDevice comDevice)
    {
        return toAjax(comDeviceService.updateComDevice(comDevice));
    }

    /**
     * 删除公司设备信息管理
     */
    @PreAuthorize("@ss.hasPermi('device:device:remove')")
    @Log(title = "公司设备信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(comDeviceService.deleteComDeviceByIds(ids));
    }
}
