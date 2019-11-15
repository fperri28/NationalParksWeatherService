package com.techelevator.npgeek.survey;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCUserDAO implements UserDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCUserDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public User addUser(String emailAddress, String password) {
		User theUser = null;
		String sqlUser = "insert into park_user (emailAddress, password) " + "values (?, ?) ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlUser, emailAddress, password);
		while (results.next()) {
			theUser = mapRowToUser(results);
		}
		return theUser;
	}

	@Override
	public User getUser(String emailAddress, String password) {
		User theUser = null;
		String sqlUser = "select * from park_user where emailAddress = ? and password = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlUser, emailAddress, password);
		while (results.next()) {
			theUser = mapRowToUser(results);
		}
		return theUser;
	}

	// --Helper Methods--

	private User mapRowToUser(SqlRowSet results) {
		User theUser = new User();
		theUser.setEmailAddress(results.getString("emailAddress"));
		theUser.setPassword(results.getString("password"));
		return theUser;
	}

}
