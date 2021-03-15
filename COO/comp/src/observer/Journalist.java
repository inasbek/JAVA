/**
 * 
 */
package observer;

import competition.Competitor;

/**
 * @author bairouk,bekkouche
 */

/**
 * the class journalist
 * */
public class Journalist implements MatchObserver{

	/*
	 * it prints the reaction to the match with changing the players cotes
	 * @param winner : a player 
	 * @param loser : a player
	 * */
	
	@Override
	public void reactToMatch(Competitor winner , Competitor loser) {
		System.out.println(" Journalist :");
		
		int minus = ((loser.getPoints()!=0)? loser.getPoints():0);
		
		System.out.println("The winner is " + winner.getName());
		System.out.println( winner.getName() + " score is  "  + (winner.getPoints()+1));
		System.out.println( loser.getName() + " score stays at  "  +  minus);
	}

}
