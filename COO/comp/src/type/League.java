/**
 * 
 */
package type;

import java.util.List;
import java.util.Map;

import competition.*;
import match.Match;


/**
 * @author bairouk,Bekkouche
 *
 */

/**
 * Creates a League
 */
public class League extends Competition {
	
	/**
	 * Constructs a League .
	 * @param competitors the competitors in a list
	 * @param match the match that we 're playing
	 */
	public League(List<Competitor> competitors, Match match) {
		super(competitors, match);
	}

	
	/**
	 * Starts the league 
	 * @param competitors the competitors in a list .
	 */
	@Override
	protected void play(List<Competitor> competitors) {
		for(Competitor c1 : competitors)
			for(Competitor c2 : competitors)
				if (! c1.equals(c2)) {
					Competitor gagnant = super.playMatch(c1,c2);
					gagnant.addPoints(1);
				}
				printRanking();
		
	}

	/**
	 * Prints the competitor's ranking of the league.
	 */
	private void printRanking() {
		Map<Competitor, Integer> ranking = this.ranking();
		System.out.println("\n*** Ranking ***");  
		for(Competitor c : ranking.keySet()) {
			System.out.println(c.getName() + " - " + ranking.get(c));  
		}
			
	}

	/**
	* Starts the matches between two competitors  and prints the winner .
	* @param c1 the first competitor 
	* @param c2 the second competitor 
	* @return the winner
	*/
	/*@Override
	protected Competitor playMatch(Competitor c1, Competitor c2) {
		Competitor gagnant = this.getMatch().consequence(c1,c2);
		gagnant.addPoints(1);
		System.out.println(c1.getName() + " vs " + c2.getName() + " ---> " + gagnant.getName() + " wins! ");
		return gagnant;
		
	}*/

}
