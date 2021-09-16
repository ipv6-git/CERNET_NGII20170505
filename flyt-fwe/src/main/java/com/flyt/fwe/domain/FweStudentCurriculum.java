package com.flyt.fwe.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.flyt.common.core.domain.BaseEntity;

/**
 * 课程学生表 fwe_student_curriculum
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public class FweStudentCurriculum extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private Long id;
	/** 学生ID */
	private Long studentId;
	/** 课程ID */
	private Long curriculumId;
	/** 课程安排ID */
	private Long curriculumScheduleId;

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
	public void setCurriculumId(Long curriculumId) 
	{
		this.curriculumId = curriculumId;
	}

	public Long getCurriculumId() 
	{
		return curriculumId;
	}
	public void setCurriculumScheduleId(Long curriculumScheduleId) 
	{
		this.curriculumScheduleId = curriculumScheduleId;
	}

	public Long getCurriculumScheduleId() 
	{
		return curriculumScheduleId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentId", getStudentId())
            .append("curriculumId", getCurriculumId())
            .append("curriculumScheduleId", getCurriculumScheduleId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
