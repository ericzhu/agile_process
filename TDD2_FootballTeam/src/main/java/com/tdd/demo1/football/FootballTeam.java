package com.tdd.demo1.football;

public class FootballTeam implements Comparable<FootballTeam> {

	private int gamesWon;

	public FootballTeam(int gamesWon) {
		if (gamesWon < 0) {
			throw new IllegalArgumentException("The gamesWon passed to constructor should be positive, but the actual is [" + gamesWon + "]");
		}
		this.gamesWon = gamesWon;
	}

	/**
	 * The number of the games won by this team.
	 * 
	 * @return
	 */
	public int getGamesWon() {
		return this.gamesWon;
	}

	@Override
	public int compareTo(FootballTeam o) {
		
		return this.gamesWon - o.getGamesWon();
	}
}
