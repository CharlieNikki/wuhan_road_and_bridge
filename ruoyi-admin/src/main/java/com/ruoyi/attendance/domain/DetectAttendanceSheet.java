package com.ruoyi.attendance.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 外检考勤对象 detect_attendance_sheet
 * 
 * @author yzw
 * @date 2022-12-25
 */
public class DetectAttendanceSheet extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一标识 */
    private Integer id;

    /** 考勤人员id */
    @Excel(name = "考勤人员id")
    private String userId;

    /** 考勤人员签到时间 */
    @Excel(name = "考勤人员签到时间")
    private String date;

    /** 考勤人员签到地点 */
    @Excel(name = "考勤人员签到地点")
    private String location;

    /** 经度 */
    @Excel(name = "经度")
    private BigDecimal longitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private BigDecimal latitude;

    /** 考勤人员姓名 */
    @Excel(name = "考勤人员姓名")
    private String username;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setDate(String date) 
    {
        this.date = date;
    }

    public String getDate() 
    {
        return date;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setLongitude(BigDecimal longitude) 
    {
        this.longitude = longitude;
    }

    public BigDecimal getLongitude() 
    {
        return longitude;
    }
    public void setLatitude(BigDecimal latitude) 
    {
        this.latitude = latitude;
    }

    public BigDecimal getLatitude() 
    {
        return latitude;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("date", getDate())
            .append("location", getLocation())
            .append("longitude", getLongitude())
            .append("latitude", getLatitude())
            .append("username", getUsername())
            .toString();
    }
}
