package com.techelevator.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.techelevator.dao.TeamsDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.Teams;
import com.techelevator.model.User;

@RestController
@CrossOrigin
public class UserController {
	
	public String authToken = "";
	
	private UserDAO userDAO;
	
	private Teams team;
	
	private final RestTemplate restTemplate = new RestTemplate();
	
	public UserController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	@RequestMapping (value ="/all-users", method = RequestMethod.GET)
	public List<User> findAll(){
		return userDAO.findAll();
	}
}
	