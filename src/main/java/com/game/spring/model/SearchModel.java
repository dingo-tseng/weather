package com.game.spring.model;

public class SearchModel {
	private String city;
	private String low;
	private String high;
	private String aqiL;
	private String aqiH;
	private String flL;
	private String flH;
	private String startDate;
	private String endDate;
	
	
	public SearchModel() {}
	public SearchModel(String city, String low, String high, String aqiL, String aqiH, String flL, String flH,
			String startDate, String endDate) {
		super();
		this.city = city;
		this.low = low;
		this.high = high;
		this.aqiL = aqiL;
		this.aqiH = aqiH;
		this.flL = flL;
		this.flH = flH;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getAqiL() {
		return aqiL;
	}
	public void setAqiL(String aqiL) {
		this.aqiL = aqiL;
	}
	public String getAqiH() {
		return aqiH;
	}
	public void setAqiH(String aqiH) {
		this.aqiH = aqiH;
	}
	public String getFlL() {
		return flL;
	}
	public void setFlL(String flL) {
		this.flL = flL;
	}
	public String getFlH() {
		return flH;
	}
	public void setFlH(String flH) {
		this.flH = flH;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
