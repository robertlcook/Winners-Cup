package com.techelevator.dao;

import com.techelevator.model.Tournament;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

import com.techelevator.model.Games;

public interface TournamentDAO {
	
	List<Tournament> all();
	
	Tournament get(int id);

	Tournament create(String name, LocalDateTime startTime, int numberOfPlayers)
			throws Exception;
	
	String getName(int id);
	
	List<Games> generateGameList();
	
	Tournament randomizeTeamList();

	Tournament addTeamToTournament(int teamID, int tournamentID);

	
	Tournament addPlayer(int userID, int teamID);
}
	
 