package com.techelevator.model;

import java.sql.Time;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Tournament {

	private int tournamentID;
	private LocalDateTime startTime;
	private int numberOfPlayers;
	private String name;
	
	public Tournament(String name, int tournamentID, LocalDateTime startTime, int numberOfPlayers) {
		this.tournamentID = tournamentID;
		this.startTime = startTime;
		this.numberOfPlayers = numberOfPlayers;
		this.name = name;
	}
	
	public Tournament() {
		
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getTournamentID() {
		return tournamentID;
	}
	public void setTournamentID(int tournamentID) {
		this.tournamentID = tournamentID;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime time) {
		this.startTime = time;
	}
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	
	
	
	
}
