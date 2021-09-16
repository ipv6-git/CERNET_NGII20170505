package com.flyt.fwe.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.flyt.common.core.domain.BaseEntity;

/**
 * 校区表 fwe_campus
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public class FweCampus extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private Long id;
	/** 校区名称 */
	private String campusName;
	/** 校区编号 */
	private String campusNo;
	/** 校区别称 */
	private String campusNickname;
	/** 校区所属省:d_province */
	private String province;
	/** 校区所在城市:d_city */
	private String city;
	/** 校区所在区:d_district */
	private String district;
	/** 校区详址 */
	private String address;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setCampusName(String campusName) 
	{
		this.campusName = campusName;
	}

	public String getCampusName() 
	{
		return campusName;
	}
	public void setCampusNo(String campusNo) 
	{
		this.campusNo = campusNo;
	}

	public String getCampusNo() 
	{
		return campusNo;
	}
	public void setCampusNickname(String campusNickname) 
	{
		this.campusNickname = campusNickname;
	}

	public String getCampusNickname() 
	{
		return campusNickname;
	}
	public void setProvince(String province) 
	{
		this.province = province;
	}

	public String getProvince() 
	{
		return province;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}

	public String getCity() 
	{
		return city;
	}
	public void setDistrict(String district) 
	{
		this.district = district;
	}

	public String getDistrict() 
	{
		return district;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getAddress() 
	{
		return address;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("campusName", getCampusName())
            .append("campusNo", getCampusNo())
            .append("campusNickname", getCampusNickname())
            .append("province", getProvince())
            .append("city", getCity())
            .append("district", getDistrict())
            .append("address", getAddress())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
