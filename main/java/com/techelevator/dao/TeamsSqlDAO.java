package com.techelevator.dao;

import com.techelevator.model.Teams;
import com.techelevator.model.User;

import java.util.List;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class TeamsSqlDAO implements TeamsDAO {
	
	private JdbcTemplate jdbcTemplate;

	private TeamsSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Teams createTeam(String teamName) throws Exception {
		try{ 
			String query = "INSERT INTO teams (team_name) VALUES (?)";
		jdbcTemplate.update(query, teamName);
		return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Teams invite(int inviterID, int invitedID) {
		String query = "INSERT INTO invited_players(inviter_id, invited_id) (\r\n" + 
				"        SELECT\r\n" + 
				"              (SELECT user_id FROM users WHERE user_id = ?),\r\n" + 
				"              (SELECT user_id FROM users WHERE user_id = ?)      \r\n" + 
				")";
		return null;
	}

	@Override
	public Teams finalizeInvite() {
		
		return null;
	}

}
