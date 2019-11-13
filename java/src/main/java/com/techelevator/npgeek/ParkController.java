package com.techelevator.npgeek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ParkController {

	@Autowired
	private ParkDAO parkDao;
		
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String displayAllParks(ModelMap map) {
		map.put("park", parkDao.getAllParks());
		return "homePage";
	}
	
	
}
