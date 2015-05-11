package com.tdd.demo1.football;

import org.junit.Test;

import static org.junit.Assert.*;

public class FootballTeamTest {

	private static final int TEN_TIMES_WON = 10;

	@Test
	public void test_constructor_setGamesWonInConstructor() {
		FootballTeam target = new FootballTeam(TEN_TIMES_WON);

		assertEquals("Games won passed in constructor is " + TEN_TIMES_WON + ", but getGameWon() returns " + //
				target.getGamesWon(), TEN_TIMES_WON, target.getGamesWon());

	}

}
