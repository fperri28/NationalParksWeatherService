package com.techelevator.npgeek.forecast;

import javax.servlet.http.HttpSession;

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
	public String displayForecast(HttpSession session, @RequestParam String parkCode) {
		session.setAttribute("forecast", forecastDao.getForecastByParkCodes(parkCode));
		return "forecast";
	}

}
