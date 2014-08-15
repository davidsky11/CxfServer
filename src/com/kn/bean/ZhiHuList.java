package com.kn.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="zhList")
public class ZhiHuList {

	private List<ZhiHu> zhihu;

	public List<ZhiHu> getZhihu() {
		return zhihu;
	}

	public void setZhihu(List<ZhiHu> zhihu) {
		this.zhihu = zhihu;
	}
	
	
}
