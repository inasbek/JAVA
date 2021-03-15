/**
 * 
 */
package observer;

import java.util.HashMap;
import java.util.Map;

import competition.Competitor;

/**
 * @author bairouk, bekkouche
 *
 */

/**
 * the class bookmaker 
 * */
public class Bookmakers implements MatchObserver {

	/**
	 * we create a map with all the players and their cotes
	 * */
	Map<Competitor, Integer> cotes = new HashMap<Competitor, Integer>();
	
	/**
	 *just the cote 
	 */
	private int cote;
	
	/**
	* the Constructer of the bookmaker .
	* @param cote :the cote
	*/
	public Bookmakers(int cote) {
		this.cote = cote;
	}
	
	/*
	 * it prints the reaction to the match with changing the players cotes
	 * @param winner : a player 
	 * @param loser : a player
	 * */
	
	@Override
	public void reactToMatch(Competitor winner, Competitor loser) {
		
		if (cotes.get(winner)==null) {
			cotes.put(winner ,  this.cote );
		}
		if (cotes.get(loser)==null) {
			cotes.put(loser,  this.cote );
		}
		
		System.out.println(" Bookmaker :");
		System.out.println( "Victoire de " + winner.getName() +" (cote " + getCote(winner) + " )" +
							 " face à " + loser.getName() + " (cote " + getCote(loser) + " )." +
							 " La cote de " + winner.getName() + " passe à " + dimunierCote(winner) + 
							 " ,celle de " + loser.getName() + " passe à " + augmenterCote(loser));
		
	}
	
	/**
	 * retourne la cote du player
	 * @param c : a player
	 * @return the cote of the player 
	 * */
	public int getCote(Competitor c) {
		return cotes.get(c);
	}
	
	/**
	 * dimunier la cote du player
	 * @param c : a player
	 * @return the cote dimunier of the player 
	 * */

	public int dimunierCote(Competitor c) {
		if (cotes.get(c) != 0) {
			cotes.replace(c, cotes.get(c) -1);
		}
		return cotes.get(c);
		
	}
	
	/**
	 * augmente la cote du player
	 * @param c : a player
	 * @return the cote augmenter of the player 
	 * */
	
	public int augmenterCote(Competitor c ) {
		cotes.replace(c, cotes.get(c) + 1);
		return cotes.get(c);
		
	} 
	
}
