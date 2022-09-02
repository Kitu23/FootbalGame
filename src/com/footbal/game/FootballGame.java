package com.footbal.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.footbal.model.Game;
import com.footbal.model.Team;

public class FootballGame {

	private List<Game> scoreBoard;
	private final Scanner scanner;
	private final String HOME_TEAM = "Home Team";
	private final String AWAY_TEAM = "Away Team";
	private int gameId = 0;

	public FootballGame() {
		scoreBoard = new ArrayList<>();
		scanner = new Scanner(System.in);
		displayMenu();
	}

	private void displayMenu() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("FootballGame Menu :");
			System.out.println("Decide Teams and Start FootballGame (press1)");
			System.out.println("Update Score of the teams in the current FootballGame(press 2)");
			System.out.println("Display the Summary of FootballGame(press 3)");
			System.out.println("Finish a  FootballGame(press4)");
			System.out.println("Finish ALl Game(press 5)");
			System.out.println();
			String line = scanner.nextLine();
			int menuItem = 0;
			try {
				menuItem = Integer.parseInt(line);
			} catch (Exception e) {
				// TODO: handle exception
			}

			switch (menuItem) {
			case 1:
				startGame();
				break;
			case 2:
				updateScore();
				break;
			case 3:
				displayGames();
				break;
			case 4:
				finishGame();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + menuItem);
			}
		}

	}

	private void finishGame() {
		// TODO Auto-generated method stub
		System.out.println("Finsh a Game");
		System.out.println("This Game will be removed from the score board");
		System.out.println("You may display entire list to get the Game Id");
		System.out.println("Enter the Game Id to finish the game");
		String line = scanner.nextLine();
		int teamId = Integer.parseInt(line);
		List<Game> games= getScoreBoard();
		for(int i =0; i< games.size(); i++ ) {
			if(games.get(i).getGameId() == teamId) {
				games.remove(i);
			}
		}

	}

	private void updateScore() {
		// TODO Auto-generated method stub
		System.out.println("Score Update for a Team");
		System.out.println("You may display entire list to get the Team Id");
		System.out.println("Enter the team Id to update the score");
		String line = scanner.nextLine();
		int teamId = Integer.parseInt(line);
		
		for(Game game : getScoreBoard()) {
			if(game.getGameId() == teamId) {
				for(Team team : game.getTeams()) {
					System.out.println("Enter updated score for team : " + team.getName());
					line = scanner.nextLine();
					try {
					team.setScore(Integer.parseInt(line));
					}catch (Exception e) {
						// TODO: handle exception
						System.out.println("Not a correct value for score. Please enter a correct value");
					}
				}
			}
		}
	}

	private void displayGames() {
		// TODO Auto-generated method stub
		List<Game> currentGames = getScoreBoard();
		for (int i = currentGames.size()-1; i >= 0  ; i--) {
			Game game = currentGames.get(i);
			int gameId = game.getGameId();
			System.out.print("Game Id : " + gameId + ". ");
			game.getTeams().forEach(team -> {
				System.out.print(team.getName() + " - " + team.getScore() + " ");
			});
			System.out.println();
		}	
	}

	private void startGame() {
		// TODO Auto-generated method stub
		Game game = new Game();
		List<Team> teams = new ArrayList<>();
		System.out.println("Welcome to a new Game..!!!");
		System.out.println("Enter the Team Names");
		System.out.println("Enter name of Home Team");
		Team homeTeam = new Team();
		String line = scanner.nextLine();
		homeTeam.setName(line);
		homeTeam.setTeamType(HOME_TEAM);
		System.out.println("Enter name of Away Team");
		line = scanner.nextLine();
		Team awayTeam = new Team();
		awayTeam.setTeamType(AWAY_TEAM);
		awayTeam.setName(line);
		teams.add(awayTeam);
		teams.add(homeTeam);
		game.setTeams(teams);
		int assginedGameId = gameId++;
		game.setGameId(assginedGameId);
		System.out.println("We have assigned Gamed Id : " + assginedGameId + " for your game.");
		addGameToScoreBoard(game);
	}

	public List<Game> getScoreBoard() {
		return scoreBoard;
	}

	public void setScoreBoard(List<Game> scoreBoard) {
		this.scoreBoard = scoreBoard;
	}

	public void addGameToScoreBoard(Game game) {
		scoreBoard.add(game);
	}

	public static void main(String[] args) {
		new FootballGame();
	}

}
