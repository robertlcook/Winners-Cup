package com.techelevator.controller;

import com.techelevator.model.Tournament;
import com.techelevator.model.TournamentTeam;
import com.techelevator.dao.TeamsDAO;
import com.techelevator.dao.TournamentDAO;
import com.techelevator.model.Games;
import com.techelevator.model.Teams;

import java.util.List;
import java.sql.Time;
import java.util.ArrayList;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin
public class TournamentController {

	public String authToken = "";
	
	private TournamentDAO tournamentDAO;
	
	private Games match;
	
	private TeamsDAO teamsDAO;
	
	private Teams team;
	
	public TournamentController(TournamentDAO tournamentDAO) {
		this.tournamentDAO = tournamentDAO;
	}
	
	
	
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	
	private final RestTemplate restTemplate = new RestTemplate();
	
	
	@RequestMapping(value = "/tournaments", method = RequestMethod.GET)
	public List<Tournament> listAll() {
		return tournamentDAO.all();
	}
	
		
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value ="/createTournament", method = RequestMethod.POST)
	public Tournament makeTournament(@RequestBody Tournament newTournament) throws Exception {
		
		return tournamentDAO.create(
				newTournament.getName(), 
				newTournament.getStartTime(),
				newTournament.getNumberOfPlayers());
	}
	
	@RequestMapping(value ="/tournaments/{id}", method = RequestMethod.GET)
	public String nameGet(@PathVariable int id) {
		return tournamentDAO.getName(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value ="/join-tournament", method = RequestMethod.POST)
	public Tournament addTeam(@RequestBody TournamentTeam tournamentTeam) {
		return tournamentDAO.addTeamToTournament(
				tournamentTeam.getTeamID(),
				tournamentTeam.getTournamentID()
				);	
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value ="/add-player", method = RequestMethod.POST)
	public Tournament addPlayer(@RequestBody TournamentTeam tournamentTeam) {
		return tournamentDAO.addPlayer(
				tournamentTeam.getTeamID(),
				tournamentTeam.getUserID()
				);	
	}
	
	@RequestMapping(value ="/all-games", method = RequestMethod.GET)
	public List<Games> getList() {
		return tournamentDAO.generateGameList();
	}
	
	
	private HttpEntity makeAuthEntity() {	
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(authToken);
		HttpEntity entity = new HttpEntity<>(headers);
		return entity;
	}
	

}

