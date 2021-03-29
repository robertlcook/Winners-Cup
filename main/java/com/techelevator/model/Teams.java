package com.techelevator.model;

import java.util.List;

public class Teams {
	private String teamName;
	private Integer teamID;
	private List<Integer> userID;
	
	public Teams(String teamName) {
		this.teamName = teamName;
	}
	
	public Teams() {
		
	}
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Integer getTeamID() {
		return teamID;
	}
	public void setTeamID(Integer teamID) {
		this.teamID = teamID;
	}
	public List<Integer> getUserID() {
		return userID;
	}
	public void setUserID(List<Integer> userID) {
		this.userID = userID;
	}
}
