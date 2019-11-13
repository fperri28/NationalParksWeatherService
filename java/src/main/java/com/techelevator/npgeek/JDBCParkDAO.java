package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCParkDAO implements ParkDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Park addPark(Park aPark) {
		return null;
	}

	@Override
	public Park getParkByCode(String aParkCode) {
		Park aPark = null;

		String sqlSearchParksByName = "select * from park where parkcode = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchParksByName, aParkCode);

		while (results.next()) {
			aPark = mapRowToPark(results);
		}
		return aPark;
	}

	@Override
	public Park getParkByName(String aParkName) {
		Park aPark = null;

		String aParkNameSearch = "%" + aParkName + "%";
		String sqlSearchParksByName = "select * from park where parkname ilike ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchParksByName, aParkNameSearch);

		while (results.next()) {
			aPark = mapRowToPark(results);
		}
		return aPark;
	}

	@Override
	public List<Park> getParksByName(String aParkName) {
		List<Park> theParksSearch = new ArrayList<Park>();
		String aParkNameSearch = "%" + aParkName + "%";
		String sqlSearchParksByName = "select * from park where parkname ilike ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchParksByName, aParkNameSearch);

		while (results.next()) {
			Park aPark = mapRowToPark(results);
			theParksSearch.add(aPark);
		}
		return theParksSearch;
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<Park>();

		String sqlListAllParksQuery = "select * from park order by parkname asc";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlListAllParksQuery);

		while (results.next()) {
			Park aPark = mapRowToPark(results);
			allParks.add(aPark);
		}
		return allParks;
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
		thePark.setClimate(results.getString("climate"));
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
