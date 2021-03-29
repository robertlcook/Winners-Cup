package com.techelevator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.techelevator.dao.TeamsDAO;
import com.techelevator.model.CreateTeamRequest;
import com.techelevator.model.Teams;

@RestController
@CrossOrigin
public class TeamsController {
	
	public String authToken = "";
	
	private TeamsDAO teamsDAO;
	
	private Teams team;
	
	private final RestTemplate restTemplate = new RestTemplate();
	
	public TeamsController(TeamsDAO teamsDAO) {
		this.teamsDAO = teamsDAO;
	}
	
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value ="/create-team", method = RequestMethod.POST)
	public Teams createTeam(@RequestBody CreateTeamRequest createTeamRequest) throws Exception {
		//Create the team
		
		//call DAO and insert team invites into invite_player
		return teamsDAO.createTeam(team.getTeamName());
	}

}
