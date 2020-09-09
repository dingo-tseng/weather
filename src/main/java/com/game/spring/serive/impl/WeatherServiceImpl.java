package com.game.spring.serive.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.game.spring.api.API;
import com.game.spring.dao.TaskLogDao;
import com.game.spring.dao.WeatherInfoDao;
import com.game.spring.entity.TaskLog;
import com.game.spring.entity.WeatherInfo;
import com.game.spring.model.BackMessage;
import com.game.spring.model.SearchModel;
import com.game.spring.model.TaskModel;
import com.game.spring.model.WeatherModel;
import com.game.spring.service.WeatherService;
import com.google.gson.*;

import net.sf.json.JSONObject;

@Service
public class WeatherServiceImpl implements WeatherService  {

	@Autowired
	private TaskLogDao taskLogDao;
	@Autowired
	private WeatherInfoDao weatherInfoDao;	
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public BackMessage saveApi(String citycode){
		//Date d=new Date();
		//WeatherInfo w=new WeatherInfo(d,d,"1","2",d,3,"4","5","6","7");
		JSONObject json=API.getAPI(citycode);
		Gson gson = new Gson();
		//JsonObject json2=new JsonObject(); //推薦
        TaskModel t = gson.fromJson(json.toString(), TaskModel.class);
		TaskLog task=new TaskLog();
		task.setCity(t.getCityInfo().getCity());
		task.setJson_txt(json.toString());
		task.setMachine_name(new Date().toString());
		task.setMessage(t.getMessage());
		task.setStatus(t.getStatus());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//SimpleDateFormat sdf=new SimpleDateFormat("mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date d1=null;
		try {
			d1 = sdf.parse(t.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		task.setUpdate_time(d1);

		//迴圈存入今天+後14天預測
		List<WeatherInfo> list=new ArrayList();
		for(WeatherModel wm:t.getData().getForecast()) {
			WeatherInfo w=new WeatherInfo();
			try {
			w.setAqi(Integer.parseInt(wm.getAqi()));
			w.setCity(t.getCityInfo().getCity());
			sdf=new SimpleDateFormat("yyyy-MM-dd");
			sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
			d1 = sdf.parse(wm.getYmd());
			w.setDate(d1);
			Integer i=null;
			i=Integer.parseInt(wm.getFl().replaceFirst("级", ""));
			w.setFl(i);
			w.setFx(wm.getFx());
			i=Integer.parseInt(wm.getHigh().replaceFirst("高温 ", "").replaceFirst("℃",""));
			w.setHigh(i);
			i=Integer.parseInt(wm.getLow().replaceFirst("低温 ", "").replaceFirst("℃",""));
			w.setLow(i);
			w.setNotice(wm.getNotice());
			sdf=new SimpleDateFormat("yyyy-MM-ddHH:mm");
			sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
			d1 = sdf.parse(wm.getYmd()+wm.getSunset());
			w.setSunset(d1);
			d1 = sdf.parse(wm.getYmd()+wm.getSunrise());
			w.setSunrise(d1);
			w.setType(wm.getType());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.add(w);
		}
		//存入昨天結果
		WeatherInfo w=new WeatherInfo();
		WeatherModel wm=t.getData().getYesterday();
		try {
		w.setAqi(Integer.parseInt(wm.getAqi()));
		w.setCity(t.getCityInfo().getCity());
		sdf=new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		d1 = sdf.parse(wm.getYmd());
		w.setDate(d1);
		Integer i=null;
		i=Integer.parseInt(wm.getFl().replaceFirst("级", ""));
		w.setFl(i);
		w.setFx(wm.getFx());
		i=Integer.parseInt(wm.getHigh().replaceFirst("高温 ", "").replaceFirst("℃",""));
		w.setHigh(i);
		i=Integer.parseInt(wm.getLow().replaceFirst("低温 ", "").replaceFirst("℃",""));
		w.setLow(i);
		w.setNotice(wm.getNotice());
		sdf=new SimpleDateFormat("yyyy-MM-ddHH:mm");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		d1 = sdf.parse(wm.getYmd()+wm.getSunset());
		w.setSunset(d1);
		d1 = sdf.parse(wm.getYmd()+wm.getSunrise());
		w.setSunrise(d1);
		w.setType(wm.getType());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list.add(w);
		taskLogDao.save(task);
		weatherInfoDao.saveAll(list);
		BackMessage msg=new BackMessage();
		msg.setData(list);
		return msg;
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public BackMessage saveAllApi(){
		saveApi("101010100");//北京
		saveApi("101020100");//上海
		saveApi("101320101");//香港
		saveApi("101340101");//台北
		saveApi("101340201");//高雄
		saveApi("101340401");//台中
		
		return null;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public BackMessage findSearch(SearchModel m) {
		BackMessage msg=null;
		try {
		String city=m.getCity();
		Integer low=Integer.parseInt(m.getLow());
		Integer high=Integer.parseInt(m.getHigh());
		Integer aqiL=Integer.parseInt(m.getAqiL());
		Integer aqiH=Integer.parseInt(m.getAqiH());
		Integer flL=Integer.parseInt(m.getFlL());
		Integer flH=Integer.parseInt(m.getFlH());
		
        List<WeatherInfo> result = weatherInfoDao.findAll(new Specification<WeatherInfo>() {
    		//private static final long serialVersionUID = 1L;
        	@Override
            public Predicate toPredicate(Root<WeatherInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<Predicate>();

                list.add(cb.equal(root.get("city").as(String.class), city));
                list.add(cb.greaterThanOrEqualTo(root.get("low").as(Integer.class), low));
                list.add(cb.lessThanOrEqualTo(root.get("high").as(Integer.class), high));
                list.add(cb.between(root.get("aqi").as(Integer.class), aqiL, aqiH));
                list.add(cb.between(root.get("fl").as(Integer.class), flL, flH));                
                //list.add(cb.like(root.get("version").as(String.class), "%" + model.getAqi() + "%"));

                // 日期
                    // 处理字符串时间
                    // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    // try {
                    // startDate = format.parse(date);
                    // } catch (ParseException e) {
                    // startDate = new Date(946656000000L);//2000 01 01
                    // }
                    // endDate = startDate;
                    // Calendar calendar = Calendar.getInstance() ;
                    // calendar.setTime(endDate);
                    // calendar.add(Calendar.DATE, 1);
                    // endDate = calendar.getTime();
                    // calendar = null;
                Date startDate =  null;
                Date endDate = null;
            	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            	format.setTimeZone(TimeZone.getTimeZone("GMT"));
            	try {
            		startDate=format.parse(m.getStartDate());
        			endDate=format.parse(m.getEndDate());
        		} catch (ParseException e) {
        			e.printStackTrace();
        		}
                    list.add(cb.between(root.<Date>get("date"), startDate, endDate));
                    
                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }

        });

        msg=new BackMessage();
		msg.setData(result);
		msg.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return msg;
    }
	
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public BackMessage test(){
		
		
		BackMessage msg=new BackMessage();

		return msg;
	}
}
