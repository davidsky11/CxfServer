package com.kn.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pic")
public class Pic {

	private int picid;
	private int zhiHuId;
	private String picName;
	private String picNameNew;
	private String picAdd;
	private String uuid;

	public int getPicid() {
		return picid;
	}

	public void setPicid(int picid) {
		this.picid = picid;
	}

	public int getZhiHuId() {
		return zhiHuId;
	}

	public void setZhiHuId(int zhiHuId) {
		this.zhiHuId = zhiHuId;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getPicNameNew() {
		return picNameNew;
	}

	public void setPicNameNew(String picNameNew) {
		this.picNameNew = picNameNew;
	}

	public String getPicAdd() {
		return picAdd;
	}

	public void setPicAdd(String picAdd) {
		this.picAdd = picAdd;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
