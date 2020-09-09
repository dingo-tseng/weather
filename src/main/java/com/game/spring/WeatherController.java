package com.game.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.game.spring.model.BackMessage;
import com.game.spring.model.SearchModel;
import com.game.spring.service.WeatherService;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/Weather")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@CrossOrigin(origins = "*")
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/saveAllApi", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BackMessage saveAllApi() {
		return weatherService.saveAllApi();
	}

	@CrossOrigin(origins = "*")
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/findSearch", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BackMessage findSearch(@RequestBody SearchModel m) {
		return weatherService.findSearch(m);
	}

	@CrossOrigin(origins = "*")
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BackMessage test() {
		return weatherService.test();
	}

}
