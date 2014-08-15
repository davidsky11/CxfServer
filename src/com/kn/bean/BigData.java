package com.kn.bean;

public class BigData {

	private String name;
	private String data;
	
	public BigData() {
		
	}
	
	public BigData(String name, int size) {
		this.name = name;
		StringBuilder sb = new StringBuilder();
		for (int i=0; i <size; i++) {
			sb.append("0");
		}
		this.data = sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
