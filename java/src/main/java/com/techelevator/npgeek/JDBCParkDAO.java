package com.techelevator.npgeek;

import java.math.BigDecimal;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.survey.Survey;

public class JDBCParkDAO implements ParkDAO{

	private JdbcTemplate jdbcTemplate;

	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Park addPark(Park newPark) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Park getParkByCode(String aParkCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Park getParkByName(String aParkName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Park> getParksByName(String aParkName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Park> getAllParks() {
		// TODO Auto-generated method stub
		return null;
	}

//	-------------------------------	HELPER METHODS	---------------------------------

	
	private Park mapRowToPark(SqlRowSet results) {
		Park thePark = new Park(); 
		
		thePark.setParkCode(results.getString("parkCode"));
		thePark.setParkName(results.getString("parkName"));		
		thePark.setState(results.getString("state"));
		thePark.setAcreage(results.getInt("acreage"));
		thePark.setElevationInFeet(results.getInt("elevationInFeet"));
		thePark.setMilesOfTrail(results.getDouble("milesOfTrail"));
		thePark.setNumberOfCampsites(results.getInt("numberOfCampsites"));		
		thePark.setYearFounded(results.getInt("yearFounded"));
		thePark.setAnnualVisitorCount(results.getInt("annualVisitorCount"));
		thePark.setInspirationalQuote(results.getString("inspirationalQuote"));
		thePark.setInspirationalQuoteSource(results.getString("inspirationalQuoteSource"));		
		thePark.setParkDescription(results.getString("parkDescription"));
		thePark.setEntryFee(results.getBigDecimal("entryFee"));		
		thePark.setNumberOfAnimalSpecies(results.getInt("numberOfAnimalSpecies"));		

		return thePark;
	}
	
}
