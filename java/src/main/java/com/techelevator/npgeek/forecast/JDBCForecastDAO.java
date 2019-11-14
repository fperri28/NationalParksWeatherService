package com.techelevator.npgeek.forecast;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCForecastDAO implements ForecastDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
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
	public Forecast getForecastByParkCode(String parkCode, String tempUnit) {
		Forecast theForecast = null;
		String sqlSearchForecastByParkCode = "select * from weather where parkcode = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForecastByParkCode, parkCode);
		while (results.next()) {
			theForecast = mapRowToForecast(results, tempUnit);
		}
		return theForecast;
	}

	@Override
	public Forecast getForecastByForecast(String forecast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Forecast> getForecastByParkCodes(String parkCode, String tempUnit) {
		List<Forecast> allForecasts = new ArrayList<Forecast>();

		String sqlListAllForecastsByParkCode = "select * from weather where parkcode = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlListAllForecastsByParkCode, parkCode);

		while (results.next()) {
			Forecast aForecast = mapRowToForecast(results, tempUnit);
			allForecasts.add(aForecast);
		}

		return allForecasts;
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

	private Forecast mapRowToForecast(SqlRowSet results, String tempUnit) {
		Forecast theForecast = new Forecast();

		theForecast.setParkCode(results.getString("parkCode"));
		theForecast.setFiveDayForecastValue(results.getInt("fiveDayForecastValue"));
		theForecast.setLow(tempUnit.equals("C") ? (results.getInt("low") - 32) * 5 / 9 : results.getInt("low"));
		theForecast.setHigh(tempUnit.equals("C") ? (results.getInt("high") - 32) * 5 / 9 : results.getInt("high"));
		theForecast.setForecast(results.getString("forecast"));

		return theForecast;
	}

}
