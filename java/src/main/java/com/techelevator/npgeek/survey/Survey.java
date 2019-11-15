package com.techelevator.npgeek.survey;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {

	private long surveyId;
	private String parkCode;
	@NotBlank(message = "Email address is required")
	@Email(message = "Email must be a valid email address")
	private String emailAddress;
	private String state;
	private String activityLevel;

	public long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(long surveyId) {
		this.surveyId = surveyId;
	}

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getActivityLevel() {
		return activityLevel;
	}

	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}

	@Override
	public String toString() {
		return "Survey [surveyId=" + surveyId + ", parkCode=" + parkCode + ", emailAddress=" + emailAddress + ", state="
				+ state + ", activityLevel=" + activityLevel + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activityLevel == null) ? 0 : activityLevel.hashCode());
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((parkCode == null) ? 0 : parkCode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + (int) (surveyId ^ (surveyId >>> 32));
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
		Survey other = (Survey) obj;
		if (activityLevel == null) {
			if (other.activityLevel != null)
				return false;
		} else if (!activityLevel.equals(other.activityLevel))
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (parkCode == null) {
			if (other.parkCode != null)
				return false;
		} else if (!parkCode.equals(other.parkCode))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (surveyId != other.surveyId)
			return false;
		return true;
	}

}
