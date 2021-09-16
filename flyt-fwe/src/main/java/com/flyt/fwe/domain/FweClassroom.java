package com.flyt.fwe.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.flyt.common.core.domain.BaseEntity;

/**
 * 教室表 fwe_classroom
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public class FweClassroom extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private Long id;
	/** 教室名称 */
	private String classroomName;
	/** 教室编号 */
	private String classroomNo;
	/** 所属校区 */
	private Long campusId;
	/** 所属教学楼 */
	private Long teachingBuildingId;
	/** 所属楼层 */
	private Long floorId;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setClassroomName(String classroomName) 
	{
		this.classroomName = classroomName;
	}

	public String getClassroomName() 
	{
		return classroomName;
	}
	public void setClassroomNo(String classroomNo) 
	{
		this.classroomNo = classroomNo;
	}

	public String getClassroomNo() 
	{
		return classroomNo;
	}
	public void setCampusId(Long campusId) 
	{
		this.campusId = campusId;
	}

	public Long getCampusId() 
	{
		return campusId;
	}
	public void setTeachingBuildingId(Long teachingBuildingId) 
	{
		this.teachingBuildingId = teachingBuildingId;
	}

	public Long getTeachingBuildingId() 
	{
		return teachingBuildingId;
	}
	public void setFloorId(Long floorId) 
	{
		this.floorId = floorId;
	}

	public Long getFloorId() 
	{
		return floorId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("classroomName", getClassroomName())
            .append("classroomNo", getClassroomNo())
            .append("campusId", getCampusId())
            .append("teachingBuildingId", getTeachingBuildingId())
            .append("floorId", getFloorId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
