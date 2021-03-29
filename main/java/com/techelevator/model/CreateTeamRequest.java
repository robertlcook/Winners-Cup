package com.techelevator.model;

public class CreateTeamRequest {
	private Teams team;
	int[] playerID;
		
public int[] getPlayerID() {
		return playerID;
	}
	public Teams getTeam() {
	return team;
}
public void setTeam(Teams team) {
	this.team = team;
}
	public void setPlayerID(int[] playerID) {
		this.playerID = playerID;
	}
	
}
