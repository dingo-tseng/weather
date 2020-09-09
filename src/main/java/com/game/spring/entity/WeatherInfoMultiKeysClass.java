package com.game.spring.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by  on 2020/8/26.
 * WeatherInfo的複合主鍵類
 *
 * @Param date
 * @Param city
 * 由這三個共同組成複合主鍵
 */
public class WeatherInfoMultiKeysClass implements Serializable {
	private Date date;
    private String city;
    
    
    public WeatherInfoMultiKeysClass() {}
	public WeatherInfoMultiKeysClass(Date date, String city) {
		super();
		this.date = date;
		this.city = city;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
    
//  ***重寫hashCode與equals方法***  劃重點！
    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((date == null) ? 0 : date.hashCode());
        result = PRIME * result + ((city == null) ? 0 : city.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }

        final WeatherInfoMultiKeysClass other = (WeatherInfoMultiKeysClass)obj;
        if(date == null){
            if(other.date != null){
                return false;
            }
        }else if(!date.equals(other.date)){
            return false;
        }
        if(city == null){
            if(other.city != null){
                return false;
            }
        }else if(!city.equals(other.city)){
            return false;
        }

        return true;
    }
}
