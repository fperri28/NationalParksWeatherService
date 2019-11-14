package com.techelevator.npgeek.forecast;

import java.util.List;

public interface ForecastDAO {

	// Create
	public Forecast addDay(Forecast newDay);

	// Read
	public Forecast getForecastByValue(int fiveDayForecastValue);

	public Forecast getForecastByParkCode(String parkCode, String tempUnit);

	public Forecast getForecastByForecast(String forecast);

	public List<Forecast> getForecastByParkCodes(String parkCode, String tempUnit);

	public List<Forecast> getForecastByForecasts(String forecast);

	// Update
	public void changeForecastData(Forecast updatedForecast);

	// Delete
	public void deleteDay(int fiveDayForecastValue, String parkCode);
}
