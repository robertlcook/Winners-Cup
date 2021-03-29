package com.techelevator.model;

public class TournamentTeam {
	
	private Integer teamID;
	private Integer tournamentID;
	private Integer userID;
	
	
	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public TournamentTeam(Integer teamID, Integer tournamentID, Integer userID) {
		this.teamID = teamID;
		this.tournamentID = tournamentID;
		this.userID = userID;
	}
	
	public TournamentTeam() {
		this.teamID = 0;
		this.tournamentID = 0;
	}

	public int getTeamID() {
		return teamID;
	}
	public void setTeamID(Integer teamID) {
		this.teamID = teamID;
	}
	public int getTournamentID() {
		return tournamentID;
	}
	public void setTournamentID(Integer tournamentID) {
		this.tournamentID = tournamentID;
	}

}
