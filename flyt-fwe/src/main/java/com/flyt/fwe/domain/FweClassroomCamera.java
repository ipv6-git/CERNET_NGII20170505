package com.flyt.fwe.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.flyt.common.core.domain.BaseEntity;

/**
 * 教室摄像机表 fwe_classroom_camera
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public class FweClassroomCamera extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private Long id;
	/** 教室ID */
	private Long classroomId;
	/** 摄像机ID */
	private Long cameraId;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setClassroomId(Long classroomId) 
	{
		this.classroomId = classroomId;
	}

	public Long getClassroomId() 
	{
		return classroomId;
	}
	public void setCameraId(Long cameraId) 
	{
		this.cameraId = cameraId;
	}

	public Long getCameraId() 
	{
		return cameraId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("classroomId", getClassroomId())
            .append("cameraId", getCameraId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
