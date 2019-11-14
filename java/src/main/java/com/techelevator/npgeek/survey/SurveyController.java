package com.techelevator.npgeek.survey;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.ParkDAO;



@Controller
public class SurveyController {

	
	@Autowired
	private SurveyDAO surveyDao;
	
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String showSurveyForm(Model modelHolder) {
		if( ! modelHolder.containsAttribute("Survey")) {
			modelHolder.addAttribute("Survey", new Survey());
		}
		return "/survey";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String submitSurveyForm(
			@Valid @ModelAttribute("Survey") Survey surveyFormValues,
			BindingResult result,			
			RedirectAttributes flash)	{	
	
		if(result.hasErrors()) {			
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Survey", result);
			flash.addFlashAttribute("Survey", surveyFormValues);
			return "redirect:/survey";
		}
		
		flash.addFlashAttribute("message", "You have successfully submitted a surveyed.");
		
		return "redirect:/confirmation";
	}
	
}
