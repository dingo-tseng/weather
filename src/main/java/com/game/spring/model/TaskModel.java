package com.game.spring.model;

import java.util.List;

public class TaskModel {
	private String message;
	private String status;
	private String date;
	private String time;
	private CityInfo cityInfo;
	private Data data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public CityInfo getCityInfo() {
		return cityInfo;
	}
	public void setCityInfo(CityInfo cityInfo) {
		this.cityInfo = cityInfo;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	
}




