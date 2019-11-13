package com.techelevator.npgeek.forecast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ForecastController {

	@Autowired
	private ForecastDAO forecastDao;

	@RequestMapping(path = "/forecast", method = RequestMethod.GET)
	public String displayForecast(ModelMap map, @RequestParam String parkCode) {
		map.put("forecast", forecastDao.getForecastByParkCode(parkCode));
		return "forecast";
	}

}
