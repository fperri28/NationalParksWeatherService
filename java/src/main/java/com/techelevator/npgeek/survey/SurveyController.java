package com.techelevator.npgeek.survey;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.ParkDAO;

@Controller
public class SurveyController {

	@Autowired
	private SurveyDAO surveyDao;
	
	@Autowired
	private ParkDAO parkDao;

	@RequestMapping(path = "/survey", method = RequestMethod.GET)
	public String showSurveyForm(Model modelHolder) {
		if (!modelHolder.containsAttribute("Survey")) {
			modelHolder.addAttribute("Survey", new Survey());
		}
		return "/survey";
	}

	@RequestMapping(path = "/survey", method = RequestMethod.POST)
	public String saveSurvey(@Valid @ModelAttribute("Survey") Survey surveyFormValues, BindingResult result,
			RedirectAttributes flash, ModelMap map, HttpSession session) {
		
		List<Park> listParks = parkDao.getAllParks();
		
		session.setAttribute("listParks", listParks);

		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Survey", result);
			flash.addFlashAttribute("Survey", surveyFormValues);
			return "redirect:/survey";
		}
		
		String parkCode = surveyFormValues.getParkCode();
		String emailAddress = surveyFormValues.getEmailAddress();
		String state = surveyFormValues.getState();
		String activityLevel = surveyFormValues.getActivityLevel();
		
		
		surveyDao.addSurvey(parkCode, emailAddress, state, activityLevel);

		map.put("post", parkDao.getSurveyCountByParkCode());

		return "/surveyResults";

	}

}
