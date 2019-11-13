package com.techelevator.npgeek.survey;

import java.util.List;

public interface SurveyDAO {

	//Create
	public Survey addSurvey(Survey newSurvey);
	
	//Read
	public Survey getSurveyById(long surveyId);
	
	public Survey getSurveyByParkCode(String parkCode);
	
	public List<Survey> getSurveysById(long surveyId);
	
	public List<Survey> getSurveysByParkCode(String parkCode);
	
	//Update
	public void changeSurveyData(Survey updatedSurvey);
	
	//Delete
	public void deleteSurveyById(long surveyId);
	
	public void deleteSurveyByParkCode(String parkCode);
	
}
