package com.kn.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "geo")
public class Geo {

	private String longitude;
	private String latitude;

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
}
