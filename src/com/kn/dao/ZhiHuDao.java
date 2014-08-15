package com.kn.dao;

import java.util.List;

import com.kn.bean.ZhiHu;

public interface ZhiHuDao extends CommonDao<ZhiHu> {

	public ZhiHu getZhiHuByById(long zhihuId);
	
	public List<ZhiHu> getZhiHuByUsername(String username);

	public void insertZhiHu(ZhiHu comm);
}
