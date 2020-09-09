package com.game.spring.service;

import com.game.spring.model.BackMessage;
import com.game.spring.model.SearchModel;

public interface WeatherService {

	public BackMessage test();
	public BackMessage saveApi(String citycode);
	public BackMessage saveAllApi();
	public BackMessage findSearch(SearchModel m);
}
