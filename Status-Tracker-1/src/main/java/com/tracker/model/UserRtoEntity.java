package com.tracker.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class UserRtoEntity {
	
	
	
	@Id
	private int userRtoID;
	
	private List<UserRtoDataEntity> userRTOData;

	public int getUserRtoID() {
		return userRtoID;
	}

	public void setUserRtoID(int userRtoID) {
		this.userRtoID = userRtoID;
	}

	public List<UserRtoDataEntity> getUserRTOData() {
		return userRTOData;
	}

	public void setUserRTOData(List<UserRtoDataEntity> userRTOData) {
		this.userRTOData = userRTOData;
	}
	
	
	
	
	
	

	
	
	

}
