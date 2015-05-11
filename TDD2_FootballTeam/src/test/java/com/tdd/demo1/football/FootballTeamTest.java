package com.tdd.demo1.football;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest {

	private static final int TEN_TIMES_WON = 10;
	private static final int TWO_TIMES_WON = 2;
	private static final int ANY_NUMBER = 123;

	@SuppressWarnings("unused")
	private static final Object[] nbOfValidGamesWon() {
		return new Object[][] { { 1 }, { 10 }, { 100 } };
	}

	@SuppressWarnings("unused")
	private static final Object[] invalidNbOfValidGamesWon() {
		return new Object[][] { { -1 }, { -10 }, { -100 } };
	}

	@Test
	@Parameters(method = "nbOfValidGamesWon")
	public void test_constructor_constructorShouldSetGamesWon(int nbOfGamesWon) {
		FootballTeam target = new FootballTeam(nbOfGamesWon);

		assertEquals("Games won passed in constructor is " + nbOfGamesWon + ", but getGameWon() returns " + //
				target.getGamesWon(), nbOfGamesWon, target.getGamesWon());

	}

	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "invalidNbOfValidGamesWon")
	public void test_constructor_GamesWonShouldNotBeNegative(int gamesWon) {
		new FootballTeam(gamesWon);
	}

	@Test
	public void test_instanceOfFootballTeamShouldBeComparable() {
		assertTrue("The FootballTeam class should implement Comparable", new FootballTeam(ANY_NUMBER) instanceof Comparable);
	}

	@Test
	public void test_compareTo_moreGamesWonShouldBeGreater() {
		FootballTeam tenTimesWon = new FootballTeam(TEN_TIMES_WON);
		FootballTeam twoTimesWon = new FootballTeam(TWO_TIMES_WON);

		assertTrue("Team wan " + TEN_TIMES_WON + " times should be greater than team wan " + TWO_TIMES_WON + " times", tenTimesWon.compareTo(twoTimesWon) > 0);

	}

	@Test
	public void test_compareTo_lessGamesWonShouldBeSmaller() {
		FootballTeam twoTimesWon = new FootballTeam(TWO_TIMES_WON);
		FootballTeam tenTimesWon = new FootballTeam(TEN_TIMES_WON);

		assertTrue("Team wan " + TWO_TIMES_WON + " times should be smaller than team wan " + TEN_TIMES_WON + " times", twoTimesWon.compareTo(tenTimesWon) < 0);

	}

	@Test
	public void test_compareTo_sameNbOfGamesWonShouldBeEqual() {
		FootballTeam team1 = new FootballTeam(ANY_NUMBER);
		FootballTeam team2 = new FootballTeam(ANY_NUMBER);

		assertTrue("Teams with the same number of games won should be equal", team1.compareTo(team2) == 0);
	}

}
