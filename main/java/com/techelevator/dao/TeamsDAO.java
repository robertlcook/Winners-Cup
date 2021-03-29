package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Teams;


public interface TeamsDAO {
	public Teams createTeam(String teamName) throws Exception;
	
	public Teams invite(int inviterID, int invitedID);
	
	public Teams finalizeInvite();
}
                                                                                          