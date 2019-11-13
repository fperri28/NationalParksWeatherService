package com.techelevator.npgeek.survey;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;


public class JDBCSurveyDAO implements SurveyDAO{
	
	private JdbcTemplate jdbcTemplate;

	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Survey addSurvey(Survey newSurvey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Survey getSurveyById(long surveyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Survey getSurveyByParkCode(String parkCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Survey> getSurveysById(long surveyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Survey> getSurveysByParkCode(String parkCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeSurveyData(Survey updatedSurvey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSurveyById(long surveyId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSurveyByParkCode(String parkCode) {
		// TODO Auto-generated method stub
		
	}
	
//	-------------------------------	HELPER METHODS	---------------------------------

	private int getNextSurveyId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_surveyId')");
		if (nextIdResult.next()) {
			return nextIdResult.getInt(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new survey");
		}
	}
	
	private Survey mapRowToSurvey(SqlRowSet results) {
		Survey theSurvey = new Survey(); 
		
		theSurvey.setSurveyId(results.getLong("surveyId"));
		theSurvey.setParkCode(results.getString("parkCode"));		
		theSurvey.setEmailAddress(results.getString("emailAddress"));
		theSurvey.setState(results.getString("state"));
		theSurvey.setActivityLevel(results.getString("activityLevel"));
		
		return theSurvey;
	}


}
