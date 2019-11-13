package com.techelevator.npgeek.forecast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ForecastController {

	@Autowired
	private JDBCForecastDAO forecastDao;
	
}
