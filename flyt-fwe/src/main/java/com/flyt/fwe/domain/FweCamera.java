package com.flyt.fwe.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.flyt.common.core.domain.BaseEntity;

/**
 * 摄像机表 fwe_camera
 * 
 * @author Wwang
 * @date 2019-06-17
 */
public class FweCamera extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private Long id;
	/** 类型 */
	private String type;
	/** 唯一编号 */
	private String cameraUniqueId;
	/** 名称 */
	private String name;
	/** 型号 */
	private String model;
	/** IP */
	private String ip;
	/** 端口 */
	private String port;
	/** 账号 */
	private String acountName;
	/** 密码 */
	private String passwd;
	/** URL */
	private String uri;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setType(String type) 
	{
		this.type = type;
	}

	public String getType() 
	{
		return type;
	}
	public void setCameraUniqueId(String cameraUniqueId) 
	{
		this.cameraUniqueId = cameraUniqueId;
	}

	public String getCameraUniqueId() 
	{
		return cameraUniqueId;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setModel(String model) 
	{
		this.model = model;
	}

	public String getModel() 
	{
		return model;
	}
	public void setIp(String ip) 
	{
		this.ip = ip;
	}

	public String getIp() 
	{
		return ip;
	}
	public void setPort(String port) 
	{
		this.port = port;
	}

	public String getPort() 
	{
		return port;
	}
	public void setAcountName(String acountName) 
	{
		this.acountName = acountName;
	}

	public String getAcountName() 
	{
		return acountName;
	}
	public void setPasswd(String passwd) 
	{
		this.passwd = passwd;
	}

	public String getPasswd() 
	{
		return passwd;
	}
	public void setUri(String uri) 
	{
		this.uri = uri;
	}

	public String getUri() 
	{
		return uri;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("cameraUniqueId", getCameraUniqueId())
            .append("name", getName())
            .append("model", getModel())
            .append("ip", getIp())
            .append("port", getPort())
            .append("acountName", getAcountName())
            .append("passwd", getPasswd())
            .append("uri", getUri())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
