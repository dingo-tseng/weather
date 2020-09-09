package com.game.spring.model;

import java.util.List;

public class Data{
	private String shidu;
	private String pm25;
	private String quality;
	private String wendu;
	private String ganmao;
	private List<WeatherModel> forecast;
	private WeatherModel yesterday;
	
	public String getShidu() {
		return shidu;
	}
	public void setShidu(String shidu) {
		this.shidu = shidu;
	}
	public String getPm25() {
		return pm25;
	}
	public void setPm25(String pm25) {
		this.pm25 = pm25;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getWendu() {
		return wendu;
	}
	public void setWendu(String wendu) {
		this.wendu = wendu;
	}
	public String getGanmao() {
		return ganmao;
	}
	public void setGanmao(String ganmao) {
		this.ganmao = ganmao;
	}
	public List<WeatherModel> getForecast() {
		return forecast;
	}
	public void setForecast(List<WeatherModel> forecast) {
		this.forecast = forecast;
	}
	public WeatherModel getYesterday() {
		return yesterday;
	}
	public void setYesterday(WeatherModel yesterday) {
		this.yesterday = yesterday;
	}
	
}