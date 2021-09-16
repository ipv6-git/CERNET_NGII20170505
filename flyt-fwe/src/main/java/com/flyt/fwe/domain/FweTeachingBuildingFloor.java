package com.flyt.fwe.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.flyt.common.core.domain.BaseEntity;

/**
 * 教学楼楼层表 fwe_teaching_building_floor
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public class FweTeachingBuildingFloor extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private Long id;
	/** 楼层名称 */
	private String floorName;
	/** 楼层编号 */
	private String floorNo;
	/** 所属校区 */
	private Long campusId;
	/** 所属教学楼 */
	private Long teachingBuildingId;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setFloorName(String floorName) 
	{
		this.floorName = floorName;
	}

	public String getFloorName() 
	{
		return floorName;
	}
	public void setFloorNo(String floorNo) 
	{
		this.floorNo = floorNo;
	}

	public String getFloorNo() 
	{
		return floorNo;
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

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("floorName", getFloorName())
            .append("floorNo", getFloorNo())
            .append("campusId", getCampusId())
            .append("teachingBuildingId", getTeachingBuildingId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
