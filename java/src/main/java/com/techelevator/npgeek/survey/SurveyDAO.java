package com.techelevator.npgeek.survey;

import java.util.List;

public interface SurveyDAO {

	// Create
	public Survey addSurvey(String parkCode, String emailAddress, String state, String activityLeve);

	// Read
	public Survey getSurveyById(long surveyId);

	public Survey getSurveyByParkCode(String parkCode);

	public List<Survey> getAllSurveys();

	public List<Survey> getSurveysByParkCode();

	// Update
	public void changeSurveyData(Survey updatedSurvey);

	// Delete
	public void deleteSurveyById(long surveyId);

	public void deleteSurveyByParkCode(String parkCode);

}
