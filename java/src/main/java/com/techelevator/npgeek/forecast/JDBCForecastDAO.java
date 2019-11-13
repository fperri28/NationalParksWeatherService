package com.techelevator.npgeek.forecast;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.survey.Survey;

public class JDBCForecastDAO implements ForecastDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCForecastDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Forecast addDay(Forecast newDay) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Forecast getForecastByValue(int fiveDayForecastValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Forecast getForecastByParkCode(String parkCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Forecast getForecastByForecast(String forecast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Forecast> getForecastByParkCodes(String parkCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Forecast> getForecastByForecasts(String forecast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeForecastData(Forecast updatedForecast) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDay(int fiveDayForecastValue, String parkCode) {
		// TODO Auto-generated method stub
		
	}
	
//	-------------------------------	HELPER METHODS	---------------------------------

	
	private Forecast mapRowToForecast(SqlRowSet results) {
		Forecast theForecast = new Forecast(); 
		
		theForecast.setParkCode(results.getString("parkCode"));		
		theForecast.setFiveDayForecastValue(results.getInt("fiveDayForecastValue"));
		theForecast.setLow(results.getInt("low"));
		theForecast.setHigh(results.getInt("high"));
		theForecast.setForecast(results.getString("forecast"));
		
		return theForecast;
	}
	

}
