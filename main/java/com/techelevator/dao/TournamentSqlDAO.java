package com.techelevator.dao;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter; 

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Games;
import com.techelevator.model.Tournament;
import com.techelevator.model.TournamentTeam;

import java.sql.Time;


@Component
public class TournamentSqlDAO implements TournamentDAO {

	private JdbcTemplate jdbcTemplate;

	private TournamentSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Tournament addPlayer(int userID, int teamID) {
		String query = "INSERT INTO team_player VALUES (?, ?)";
		jdbcTemplate.update(query, userID, teamID);
		return null;
	}
	
	@Override
	public Tournament addTeamToTournament(int teamID, int tournamentID) {
		String query = "INSERT INTO tournament_teams (team_id, tournament_id) VALUES (?, ?);";
		jdbcTemplate.update(query, teamID, tournamentID);
		
		
		return null;
	}



	@Override
	public Tournament create(String name, LocalDateTime startTime, int numberOfPlayers) {
		try {
			
			String query = "insert into tournaments "
					+ "(tournament_name, start_date, number_of_participants)"
					+ " values(?, ?, ?)";
		jdbcTemplate.update(query, name, startTime, numberOfPlayers);
		} catch (Exception ex) {
			ex.printStackTrace();	
			throw ex;
		}
		return null;
	}
	
	@Override
	public String getName(int id) {
		Tournament foundName = null;
		String query = "SELECT tournament_name FROM tournaments WHERE tournament_id =" + id;
		SqlRowSet result = jdbcTemplate.queryForRowSet(query);
		if(result.next()) {
			return result.getString("tournament_name");
		}
		return null;
	}

	@Override
	public List<Tournament> all() {
		String query = "SELECT * FROM tournaments";
		List<Tournament> allTournaments = new ArrayList<>();
		SqlRowSet result = jdbcTemplate.queryForRowSet(query);
		while(result.next()) {
			Tournament tournament = mapRow(result);
			allTournaments.add(tournament);
			
		}
		return allTournaments;
	}

	@Override
	public Tournament get(int id) {
		String query = "SELECT * FROM tournaments WHERE tournament_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(query);
		return null;
	}


	@Override
	public List<Games> generateGameList() {
		String query = "SELECT game_name FROM games";
		List<Games> allGames = new ArrayList<>();
		SqlRowSet result = jdbcTemplate.queryForRowSet(query);
		while(result.next()) {
			Games game = mapGame(result);
			allGames.add(game);
		}	
		return allGames;
	}

	@Override
	public Tournament randomizeTeamList() {
		// TODO Auto-generated method stub
		return null;
	}
	

	private Tournament mapRow(SqlRowSet rw) {
	  
	  Tournament tournament = new Tournament();
	  tournament.setName(rw.getString("tournament_name"));
	  tournament.setNumberOfPlayers(rw.getInt("number_of_participants"));
	  tournament.setStartTime(rw.getTimestamp("start_date").toLocalDateTime());
	  tournament.setTournamentID(rw.getInt("tournament_id"));
	  return tournament;
	  
	 }
	
	private TournamentTeam mapRowToTournamentTeam(SqlRowSet rw) {
	 TournamentTeam tournamentTeam = new TournamentTeam();
	 tournamentTeam.setTeamID(rw.getInt("team_id"));
	 tournamentTeam.setTournamentID(rw.getInt("tournament_id"));
	 return tournamentTeam;
	}
	
	private Games mapGame(SqlRowSet rw) {
	 Games game = new Games();
	 game.setGameName(rw.getString("game_name"));
	 game.setGameID(rw.getInt("game_id"));
	 game.setStartTimeDate(rw.getTimestamp("start_time").toLocalDateTime());
	 game.setOrganizer(rw.getString("organizer"));
	 game.setNumberOfPlayers(rw.getInt("number_of_players"));
	 game.setWinner(rw.getString("winning_team"));
	 return game;
	}
}
