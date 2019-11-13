package com.techelevator.npgeek;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ParkController {

	@Autowired
	private ParkDAO parkDao;
		
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String displayAllParks(ModelMap map) {
		map.put("park", parkDao.getAllParks());
		return "homePage";
	}
	
	@RequestMapping("/parkDetail")
	public String displayParkDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		try {
			String parkCodeParameter = request.getParameter("parkCode");
			
			request.setAttribute("park", parkDao.getParkByCode(parkCodeParameter));
			return "parkDetail";
			
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}
	
	
	
}
