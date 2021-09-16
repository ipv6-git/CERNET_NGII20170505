package com.flyt.fwe.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.flyt.common.core.domain.BaseEntity;

/**
 * 学生表 fwe_student
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public class FweStudent extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private Long id;
	/** 姓名 */
	private String name;
	/** 学号 */
	private String studentNo;
	/** 所属学院 */
	private Long collegeId;
	/** 所属专业 */
	private Long majorId;
	/** 所属班级 */
	private Long classId;
	/** 照片 */
	private String picture;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setStudentNo(String studentNo) 
	{
		this.studentNo = studentNo;
	}

	public String getStudentNo() 
	{
		return studentNo;
	}
	public void setCollegeId(Long collegeId) 
	{
		this.collegeId = collegeId;
	}

	public Long getCollegeId() 
	{
		return collegeId;
	}
	public void setMajorId(Long majorId) 
	{
		this.majorId = majorId;
	}

	public Long getMajorId() 
	{
		return majorId;
	}
	public void setClassId(Long classId) 
	{
		this.classId = classId;
	}

	public Long getClassId() 
	{
		return classId;
	}
	public void setPicture(String picture) 
	{
		this.picture = picture;
	}

	public String getPicture() 
	{
		return picture;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("studentNo", getStudentNo())
            .append("collegeId", getCollegeId())
            .append("majorId", getMajorId())
            .append("classId", getClassId())
            .append("picture", getPicture())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
