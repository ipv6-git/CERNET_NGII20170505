package com.flyt.fwe.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.flyt.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 缺课白名单表 fwe_student_white_list
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public class FweStudentWhiteList extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private Long id;
	/** 学生ID */
	private Long studentId;
	/** 类型:请假,休学,其它原因 */
	private String type;
	/** 起始时间 */
	private Date startTime;
	/** 结束时间 */
	private Date endTime;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setStudentId(Long studentId) 
	{
		this.studentId = studentId;
	}

	public Long getStudentId() 
	{
		return studentId;
	}
	public void setType(String type) 
	{
		this.type = type;
	}

	public String getType() 
	{
		return type;
	}
	public void setStartTime(Date startTime) 
	{
		this.startTime = startTime;
	}

	public Date getStartTime() 
	{
		return startTime;
	}
	public void setEndTime(Date endTime) 
	{
		this.endTime = endTime;
	}

	public Date getEndTime() 
	{
		return endTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentId", getStudentId())
            .append("type", getType())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
