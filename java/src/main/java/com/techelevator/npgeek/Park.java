package com.techelevator.npgeek;

import java.math.BigDecimal;

public class Park {

	private String parkCode;
	private String parkName;
	private String state;
	private int acreage;
	private int elevationInFeet;
	private double milesOfTrail;
	private int numberOfCampsites;
	private String climate;
	private int yearFounded;
	private int annualVisitorCount;
	private String inspirationalQuote;
	private String inspirationalQuoteSource;
	private String parkDescription;
	private BigDecimal entryFee;
	private int numberOfAnimalSpecies;
	private int surveycount;
	
	public int getSurveycount() {
		return surveycount;
	}
	public void setSurveycount(int surveycount) {
		this.surveycount = surveycount;
	}
	
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getAcreage() {
		return acreage;
	}
	public void setAcreage(int acreage) {
		this.acreage = acreage;
	}
	public int getElevationInFeet() {
		return elevationInFeet;
	}
	public void setElevationInFeet(int elevationInFeet) {
		this.elevationInFeet = elevationInFeet;
	}
	public double getMilesOfTrail() {
		return milesOfTrail;
	}
	public void setMilesOfTrail(double milesOfTrail) {
		this.milesOfTrail = milesOfTrail;
	}
	public int getNumberOfCampsites() {
		return numberOfCampsites;
	}
	public void setNumberOfCampsites(int numberOfCampsites) {
		this.numberOfCampsites = numberOfCampsites;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public int getYearFounded() {
		return yearFounded;
	}
	public void setYearFounded(int yearFounded) {
		this.yearFounded = yearFounded;
	}
	public int getAnnualVisitorCount() {
		return annualVisitorCount;
	}
	public void setAnnualVisitorCount(int annualVisitorCount) {
		this.annualVisitorCount = annualVisitorCount;
	}
	public String getInspirationalQuote() {
		return inspirationalQuote;
	}
	public void setInspirationalQuote(String inspirationalQuote) {
		this.inspirationalQuote = inspirationalQuote;
	}
	public String getInspirationalQuoteSource() {
		return inspirationalQuoteSource;
	}
	public void setInspirationalQuoteSource(String inspirationalQuoteSource) {
		this.inspirationalQuoteSource = inspirationalQuoteSource;
	}
	public String getParkDescription() {
		return parkDescription;
	}
	public void setParkDescription(String parkDescription) {
		this.parkDescription = parkDescription;
	}
	public BigDecimal getEntryFee() {
		return entryFee;
	}
	public void setEntryFee(BigDecimal entryFee) {
		this.entryFee = entryFee;
	}
	public int getNumberOfAnimalSpecies() {
		return numberOfAnimalSpecies;
	}
	public void setNumberOfAnimalSpecies(int numberOfAnimalSpecies) {
		this.numberOfAnimalSpecies = numberOfAnimalSpecies;
	}
	@Override
	public String toString() {
		return "Park [parkCode=" + parkCode + ", parkName=" + parkName + ", state=" + state + ", acreage=" + acreage
				+ ", elevationInFeet=" + elevationInFeet + ", milesOfTrail=" + milesOfTrail + ", numberOfCampsites="
				+ numberOfCampsites + ", climate=" + climate + ", yearFounded=" + yearFounded + ", annualVisitorCount="
				+ annualVisitorCount + ", inspirationalQuote=" + inspirationalQuote + ", inspirationalQuoteSource="
				+ inspirationalQuoteSource + ", parkDescription=" + parkDescription + ", entryFee=" + entryFee
				+ ", numberOfAnimalSpecies=" + numberOfAnimalSpecies + ", surveycount=" + surveycount + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + acreage;
		result = prime * result + annualVisitorCount;
		result = prime * result + ((climate == null) ? 0 : climate.hashCode());
		result = prime * result + elevationInFeet;
		result = prime * result + ((entryFee == null) ? 0 : entryFee.hashCode());
		result = prime * result + ((inspirationalQuote == null) ? 0 : inspirationalQuote.hashCode());
		result = prime * result + ((inspirationalQuoteSource == null) ? 0 : inspirationalQuoteSource.hashCode());
		long temp;
		temp = Double.doubleToLongBits(milesOfTrail);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + numberOfAnimalSpecies;
		result = prime * result + numberOfCampsites;
		result = prime * result + ((parkCode == null) ? 0 : parkCode.hashCode());
		result = prime * result + ((parkDescription == null) ? 0 : parkDescription.hashCode());
		result = prime * result + ((parkName == null) ? 0 : parkName.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + surveycount;
		result = prime * result + yearFounded;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Park other = (Park) obj;
		if (acreage != other.acreage)
			return false;
		if (annualVisitorCount != other.annualVisitorCount)
			return false;
		if (climate == null) {
			if (other.climate != null)
				return false;
		} else if (!climate.equals(other.climate))
			return false;
		if (elevationInFeet != other.elevationInFeet)
			return false;
		if (entryFee == null) {
			if (other.entryFee != null)
				return false;
		} else if (!entryFee.equals(other.entryFee))
			return false;
		if (inspirationalQuote == null) {
			if (other.inspirationalQuote != null)
				return false;
		} else if (!inspirationalQuote.equals(other.inspirationalQuote))
			return false;
		if (inspirationalQuoteSource == null) {
			if (other.inspirationalQuoteSource != null)
				return false;
		} else if (!inspirationalQuoteSource.equals(other.inspirationalQuoteSource))
			return false;
		if (Double.doubleToLongBits(milesOfTrail) != Double.doubleToLongBits(other.milesOfTrail))
			return false;
		if (numberOfAnimalSpecies != other.numberOfAnimalSpecies)
			return false;
		if (numberOfCampsites != other.numberOfCampsites)
			return false;
		if (parkCode == null) {
			if (other.parkCode != null)
				return false;
		} else if (!parkCode.equals(other.parkCode))
			return false;
		if (parkDescription == null) {
			if (other.parkDescription != null)
				return false;
		} else if (!parkDescription.equals(other.parkDescription))
			return false;
		if (parkName == null) {
			if (other.parkName != null)
				return false;
		} else if (!parkName.equals(other.parkName))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (surveycount != other.surveycount)
			return false;
		if (yearFounded != other.yearFounded)
			return false;
		return true;
	}
	
	
	
	
	
}
