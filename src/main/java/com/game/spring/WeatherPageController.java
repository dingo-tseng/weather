package com.game.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/WeatherPage")
public class WeatherPageController {
	@RequestMapping(value = "/Result", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("../index.html");

		return mav;
	}
}