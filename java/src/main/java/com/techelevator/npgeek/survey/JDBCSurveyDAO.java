package com.techelevator.npgeek.survey;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCSurveyDAO implements SurveyDAO {

	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Survey addSurvey(String parkCode, String emailAddress, String state, String activityLevel) {
		Survey newSurvey = new Survey();

		String sqlAddNewSurvey = "insert into survey_result (surveyId,parkcode, emailaddress, state, activitylevel) "
				+ "values (?, ?, ?, ?, ?)";

		newSurvey.setSurveyId(getNextSurveyId());
		newSurvey.setParkCode(parkCode);
		newSurvey.setEmailAddress(emailAddress);
		newSurvey.setState(state);
		newSurvey.setActivityLevel(activityLevel);

		jdbcTemplate.update(sqlAddNewSurvey, newSurvey.getSurveyId(), newSurvey.getParkCode(),
				newSurvey.getEmailAddress(), newSurvey.getState(), newSurvey.getActivityLevel());

		return newSurvey;
	}

	@Override
	public Survey getSurveyById(long surveyId) {
		Survey theSurvey = null;
		String sqlSearchSurveyById = "select * from survey_result where surveyid = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchSurveyById, surveyId);
		while (results.next()) {
			theSurvey = mapRowToSurvey(results);
		}
		return theSurvey;
	}

	@Override
	public Survey getSurveyByParkCode(String parkCode) {

		Survey theSurvey = null;
		String sqlSearchSurveyByParkCode = "select * from survey_result where parkcode = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchSurveyByParkCode, parkCode);
		while (results.next()) {
			theSurvey = mapRowToSurvey(results);
		}
		return theSurvey;
	}

	@Override
	public List<Survey> getAllSurveys() {
		List<Survey> allSurveys = new ArrayList<Survey>();

		String sqlListAllSurveysQuery = "select * from survey_result order by surveyid";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlListAllSurveysQuery);

		while (results.next()) {
			Survey aSurvey = mapRowToSurvey(results);
			allSurveys.add(aSurvey);
		}

		return allSurveys;
	}

	@Override
	public List<Survey> getSurveysByParkCode() {
		List<Survey> allSurveys = new ArrayList<Survey>();

		String sqlListAllSurveysByParkCode = 	"SELECT park.*, COUNT(*) as surveycount " + 
												"FROM survey_result " + 
												"INNER JOIN park on park.parkcode = survey_result.parkcode " + 
												"GROUP BY park.parkcode " + 
												"ORDER BY surveycount DESC";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlListAllSurveysByParkCode);

		while (results.next()) {
			Survey aSurvey = mapRowToSurvey(results);
			allSurveys.add(aSurvey);
		}

		return allSurveys;
	}

	@Override
	public void changeSurveyData(Survey updatedSurvey) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSurveyById(long surveyId) {
		String sqlQuery = "delete from survey_results where surveyid = ?";
		jdbcTemplate.update(sqlQuery, surveyId);

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
