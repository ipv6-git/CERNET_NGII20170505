package com.flyt.fwe.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.flyt.common.core.domain.BaseEntity;

/**
 * 专业表 fwe_major
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public class FweMajor extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private Long id;
	/** 专业名称 */
	private String majorName;
	/** 所属学院 */
	private Long collegeId;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setMajorName(String majorName) 
	{
		this.majorName = majorName;
	}

	public String getMajorName() 
	{
		return majorName;
	}
	public void setCollegeId(Long collegeId) 
	{
		this.collegeId = collegeId;
	}

	public Long getCollegeId() 
	{
		return collegeId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("majorName", getMajorName())
            .append("collegeId", getCollegeId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
