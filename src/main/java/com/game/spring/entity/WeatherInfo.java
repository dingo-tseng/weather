package com.game.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@IdClass(WeatherInfoMultiKeysClass.class)
//@EntityListeners(AuditingEntityListener.class)
public class WeatherInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//GeneratedValue(strategy=GenerationType.IDENTITY)
	private Date date;
    @Id
	private String city;
	@Column(name = "sunrise")
	private Date sunrise;
	@Column(name = "high")
	private Integer high;
	@Column(name = "low")
	private Integer low;
	@Column(name = "sunset")
	private Date sunset;
	@Column(name = "aqi")
	private Integer aqi;
	@Column(name = "fx")
	private String fx;
	@Column(name = "fl")
	private Integer fl;
	@Column(name = "type")
	private String type;
	@Column(name = "notice")
	private String notice;
	
	public WeatherInfo() {}
	public WeatherInfo(Date date, String city, Date sunrise, Integer high, Integer low, Date sunset, Integer aqi,
			String fx, Integer fl, String type, String notice) {
		super();
		this.date = date;
		this.city = city;
		this.sunrise = sunrise;
		this.high = high;
		this.low = low;
		this.sunset = sunset;
		this.aqi = aqi;
		this.fx = fx;
		this.fl = fl;
		this.type = type;
		this.notice = notice;
	}




	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getSunrise() {
		return sunrise;
	}

	public void setSunrise(Date sunrise) {
		this.sunrise = sunrise;
	}

	public Integer getHigh() {
		return high;
	}

	public void setHigh(Integer high) {
		this.high = high;
	}

	public Integer getLow() {
		return low;
	}

	public void setLow(Integer low) {
		this.low = low;
	}

	public Date getSunset() {
		return sunset;
	}

	public void setSunset(Date sunset) {
		this.sunset = sunset;
	}

	public Integer getAqi() {
		return aqi;
	}

	public void setAqi(Integer aqi) {
		this.aqi = aqi;
	}

	public String getFx() {
		return fx;
	}

	public void setFx(String fx) {
		this.fx = fx;
	}

	public Integer getFl() {
		return fl;
	}

	public void setFl(Integer fl) {
		this.fl = fl;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

}
