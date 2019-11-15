package com.techelevator.npgeek;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.forecast.ForecastDAO;

@Controller
public class ParkController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ParkDAO parkDao;

	@Autowired
	private ForecastDAO forecastDao;

	@RequestMapping(path = "/parkDetail", method = RequestMethod.GET)
	public String displayDetail(HttpSession session, @RequestParam String parkCode, ModelMap map) {
		List<Park> listParks = parkDao.getAllParks();
		String tempUnit = (String) session.getAttribute("tempUnit");
		if (tempUnit == null) {
			tempUnit = "F";
			session.setAttribute("tempUnit", tempUnit);
		}

		session.setAttribute("listParks", listParks);
		map.addAttribute("park", parkDao.getParkByCode(parkCode));
		map.addAttribute("forecast", forecastDao.getForecastByParkCodes(parkCode, tempUnit));

		return "parkDetail";
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String displayAllParks(HttpSession session, ModelMap map) {
		List<Park> listParks = parkDao.getAllParks();
//		map.put("listParks", listParks);
		map.put("park", parkDao.getAllParks());
		session.setAttribute("listParks", listParks);
		return "homePage";
	}

	@RequestMapping(path = "/temperature", method = RequestMethod.POST)
	public String temperaturePreference(HttpSession session, @RequestParam String parkCode,
			@RequestParam String temperature, ModelMap map) {
		if (temperature.startsWith("F")) {
			session.setAttribute("tempUnit", "F");
		} else if (temperature.startsWith("C")) {
			session.setAttribute("tempUnit", "C");

		}
		return "redirect:/parkDetail?parkCode=" + parkCode;
	}

//	@RequestMapping(path = "/surveyResults", method = RequestMethod.GET)
//	public String displayParksBySurveyresults(ModelMap map) {
//
//		map.put("post", parkDao.getSurveyCountByParkCode());
//
//		return "/homePage";
//
//	}

//	@RequestMapping("/parkDetail")
//	public String displayParkDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
//	
//		try {
//			String parkCodeParameter = request.getParameter("parkCode");			
//			request.setAttribute("park", parkDao.getParkByCode(parkCodeParameter));
//			
//			return "parkDetail";
//			
//		} catch (NumberFormatException | IndexOutOfBoundsException e) {
//			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
//			return null;
//		}
//	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		listParks(request, response);
	}

	private void listParks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Park> listParks = parkDao.getAllParks();
		request.setAttribute("listParks", listParks);

		RequestDispatcher dispatcher = request.getRequestDispatcher("header.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parkName = request.getParameter("parkName");

		request.setAttribute("selectedParkName", parkName);

		listParks(request, response);
	}

}
