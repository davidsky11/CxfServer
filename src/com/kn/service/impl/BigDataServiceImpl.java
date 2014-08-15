package com.kn.service.impl;

import com.kn.bean.BigData;
import com.kn.service.BigDataService;

public class BigDataServiceImpl implements BigDataService {

	@Override
	public BigData getBigData(String name, int size) {
		BigData bigData = new BigData(name, size);
		return bigData;
	}

}
