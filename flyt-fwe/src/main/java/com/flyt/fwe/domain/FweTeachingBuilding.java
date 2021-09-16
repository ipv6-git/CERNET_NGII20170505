package com.flyt.fwe.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.flyt.common.core.domain.BaseEntity;

/**
 * 教学楼表 fwe_teaching_building
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public class FweTeachingBuilding extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private Long id;
	/** 教学楼名称 */
	private String teachingBuildingName;
	/** 教学楼编号 */
	private String teachingBuildingNo;
	/** 所属校区 */
	private Long campusId;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setTeachingBuildingName(String teachingBuildingName) 
	{
		this.teachingBuildingName = teachingBuildingName;
	}

	public String getTeachingBuildingName() 
	{
		return teachingBuildingName;
	}
	public void setTeachingBuildingNo(String teachingBuildingNo) 
	{
		this.teachingBuildingNo = teachingBuildingNo;
	}

	public String getTeachingBuildingNo() 
	{
		return teachingBuildingNo;
	}
	public void setCampusId(Long campusId) 
	{
		this.campusId = campusId;
	}

	public Long getCampusId() 
	{
		return campusId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("teachingBuildingName", getTeachingBuildingName())
            .append("teachingBuildingNo", getTeachingBuildingNo())
            .append("campusId", getCampusId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
