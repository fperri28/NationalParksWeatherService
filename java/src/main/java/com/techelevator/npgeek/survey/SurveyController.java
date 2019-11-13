package com.techelevator.npgeek.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SurveyController {

	
	@Autowired
	private JDBCSurveyDAO surveyDao;
	
	
}
