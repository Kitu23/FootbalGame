package com.footbal.model;

import java.util.List;

public class Game {

	private List<Team> teams;
	private int gameId;
	
	public Game() {
		
	}

	public Game(List<Team> teams) {
		super();
		this.teams = teams;
	}

	public List<Team> getTeams() {
		return teams;
	}

	
	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public Boolean setTeams(List<Team> teamScore) {
		Boolean set= false;
		if(teamScore.size() == 2) {
			this.teams = teamScore;
			set = true;
		}
		return set;
	}
	
	
	
	
}
