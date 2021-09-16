package com.flyt.fwe.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.flyt.common.core.domain.BaseEntity;

/**
 * 开设课程表 fwe_curriculum
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public class FweCurriculum extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private Long id;
	/** 课程编号 */
	private String curriculumNo;
	/** 课程名称 */
	private String curriculumName;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setCurriculumNo(String curriculumNo) 
	{
		this.curriculumNo = curriculumNo;
	}

	public String getCurriculumNo() 
	{
		return curriculumNo;
	}
	public void setCurriculumName(String curriculumName) 
	{
		this.curriculumName = curriculumName;
	}

	public String getCurriculumName() 
	{
		return curriculumName;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("curriculumNo", getCurriculumNo())
            .append("curriculumName", getCurriculumName())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
