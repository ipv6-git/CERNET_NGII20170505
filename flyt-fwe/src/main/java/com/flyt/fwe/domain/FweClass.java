package com.flyt.fwe.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.flyt.common.core.domain.BaseEntity;

/**
 * 班级表 fwe_class
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public class FweClass extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private Long id;
	/** 班级名称 */
	private String className;
	/** 所需学院 */
	private Long collegeId;
	/** 所属专业 */
	private Long majorId;
	/** 所属年级 */
	private String classYear;
	/** 学年制 */
	private String scholasticYearSystem;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setClassName(String className) 
	{
		this.className = className;
	}

	public String getClassName() 
	{
		return className;
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
	public void setClassYear(String classYear) 
	{
		this.classYear = classYear;
	}

	public String getClassYear() 
	{
		return classYear;
	}
	public void setScholasticYearSystem(String scholasticYearSystem) 
	{
		this.scholasticYearSystem = scholasticYearSystem;
	}

	public String getScholasticYearSystem() 
	{
		return scholasticYearSystem;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("className", getClassName())
            .append("collegeId", getCollegeId())
            .append("majorId", getMajorId())
            .append("classYear", getClassYear())
            .append("scholasticYearSystem", getScholasticYearSystem())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
