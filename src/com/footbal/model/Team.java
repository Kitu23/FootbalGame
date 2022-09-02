package com.footbal.model;

public class Team {

	private String name;
	private String teamType;
	private int score;

	public Team() {

	}

	public Team(String name, String teamType, int score) {
		super();
		this.name = name;
		this.teamType = teamType;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeamType() {
		return teamType;
	}

	public void setTeamType(String teamType) {
		this.teamType = teamType;
	}

	public int getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
}
