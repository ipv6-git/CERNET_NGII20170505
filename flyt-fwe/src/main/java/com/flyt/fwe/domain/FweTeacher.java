package com.flyt.fwe.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.flyt.common.core.domain.BaseEntity;

/**
 * 教师表 fwe_teacher
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public class FweTeacher extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private Long id;
	/** 姓名 */
	private String name;
	/** 教师编号 */
	private String teacherNo;
	/** 手机号 */
	private String phone;
	/** 所属学院 */
	private Long collegeId;
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
	public void setTeacherNo(String teacherNo) 
	{
		this.teacherNo = teacherNo;
	}

	public String getTeacherNo() 
	{
		return teacherNo;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}
	public void setCollegeId(Long collegeId) 
	{
		this.collegeId = collegeId;
	}

	public Long getCollegeId() 
	{
		return collegeId;
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
            .append("teacherNo", getTeacherNo())
            .append("phone", getPhone())
            .append("collegeId", getCollegeId())
            .append("picture", getPicture())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
