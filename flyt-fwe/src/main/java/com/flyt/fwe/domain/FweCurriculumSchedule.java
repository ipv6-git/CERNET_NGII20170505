package com.flyt.fwe.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.flyt.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 课程安排表 fwe_curriculum_schedule
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public class FweCurriculumSchedule extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private Long id;
	/** 课程ID */
	private Long curriculumId;
	/** 上课日期 */
	private Date classDate;
	/** 上课开始时间 */
	private Date classStartTime;
	/** 上课结束时间 */
	private Date classEndTime;
	/** 授课老师ID */
	private Long teacherId;
	/** 所属校区 */
	private Long campusId;
	/** 所属教学楼 */
	private Long teachingBuildingId;
	/** 所属楼层 */
	private Long floorId;
	/** 所属教室 */
	private Long classroomId;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setCurriculumId(Long curriculumId) 
	{
		this.curriculumId = curriculumId;
	}

	public Long getCurriculumId() 
	{
		return curriculumId;
	}
	public void setClassDate(Date classDate) 
	{
		this.classDate = classDate;
	}

	public Date getClassDate() 
	{
		return classDate;
	}
	public void setClassStartTime(Date classStartTime) 
	{
		this.classStartTime = classStartTime;
	}

	public Date getClassStartTime() 
	{
		return classStartTime;
	}
	public void setClassEndTime(Date classEndTime) 
	{
		this.classEndTime = classEndTime;
	}

	public Date getClassEndTime() 
	{
		return classEndTime;
	}
	public void setTeacherId(Long teacherId) 
	{
		this.teacherId = teacherId;
	}

	public Long getTeacherId() 
	{
		return teacherId;
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
	public void setClassroomId(Long classroomId) 
	{
		this.classroomId = classroomId;
	}

	public Long getClassroomId() 
	{
		return classroomId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("curriculumId", getCurriculumId())
            .append("classDate", getClassDate())
            .append("classStartTime", getClassStartTime())
            .append("classEndTime", getClassEndTime())
            .append("teacherId", getTeacherId())
            .append("campusId", getCampusId())
            .append("teachingBuildingId", getTeachingBuildingId())
            .append("floorId", getFloorId())
            .append("classroomId", getClassroomId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
