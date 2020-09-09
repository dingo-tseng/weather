package com.game.spring.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import com.game.spring.model.TaskModel;
import com.google.gson.Gson;

import net.sf.json.JSONObject;

public class API {

	public static JSONObject getAPI(String s) {
		String url = "http://t.weather.itboy.net/api/weather/city/"+s;//101030100
		JSONObject json =null;
        InputStream is=null;
		try {
		is = new URL(url).openStream();

             BufferedReader rd = new BufferedReader(new InputStreamReader(is,"utf-8")); //避免中文亂碼問題
             StringBuilder sb = new StringBuilder();
             int cp;
             while ((cp = rd.read()) != -1) {
                 sb.append((char) cp);
             }
             json = JSONObject.fromObject(sb.toString());
             //System.out.println(json);
             //Gson gson = new Gson();
            // TaskModel t = gson.fromJson(json.toString(), TaskModel.class);
             //System.out.println(t.getData().getForecast().get(12).getAqi());

        } catch (Exception e){// API資料抓取錯誤
            System.out.println("錯誤訊息:" + e.getMessage());
            System.out.println("API資料抓取錯誤");
        }
        finally {
             try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return json;
	}
}
