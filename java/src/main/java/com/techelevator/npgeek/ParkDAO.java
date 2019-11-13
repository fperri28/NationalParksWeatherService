package com.techelevator.npgeek;

import java.util.List;


public interface ParkDAO {
//CRUD - Create, Read, Update, Delete
	//Create
	public Park addPark(Park newPark);
	//Read
	public Park getParkByCode(String aParkCode);						//	Select a Park by it's ID (Primary Key)
	
	public Park getParkByName(String aParkName);					
	
	public List<Park> getParksByName(String aParkName);				//	Select a Park by it's Name
	
	public List<Park> getAllParks();							//	Return all the Park	
	//Updates
	
	//Delete
}
