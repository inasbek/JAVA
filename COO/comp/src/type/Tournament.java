/**
 * 
 */
package type;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import competition.Competition;
import competition.Competitor;
import match.Match;

/**
 * @author bairouk, Bekkouche
 *
 */

/**
 * Creates a Tournament
 */
public class Tournament extends Competition{
	
	/**
	 * Constructs a Tournament.
	 * @param competitors the competitors in a list
	 * @param match the match that we 're playing
	 */

	public Tournament(List<Competitor> competitors , Match match) {
				super(competitors, match);

		}



	/**
	 * Starts the tournament. 
	 * @param competitors the list of the competitors .
	 * and uses the fct printRanking that will print the ranking in each call
	 */
	@Override
	protected void play(List<Competitor> competitors) throws Exception{
		if(this.estPuissanceDe2(competitors.size())) {
			LinkedList<Competitor> winnersCompetitors = new LinkedList<Competitor>(competitors);
			while(winnersCompetitors.size() >2) {
				Competitor matchWinner = playMatch(winnersCompetitors.pop(), winnersCompetitors.pop());
				winnersCompetitors.add(matchWinner);
			}
			Competitor winner =playMatch(winnersCompetitors.pop(),winnersCompetitors.pop() );
			printRanking();
			System.out.println("\n The winner is : "+ winner.getName());
		}
		
		else
			throw new Exception("Error :tournois nécessite un nombre de compétiteurs puissance de 2.");
		
	}

	/**
	* Starts the matches between two competitors  and prints the winner .
	* @param  c1 the first competitor 
	* @param  c2 the second competitor 
	* @return the winner
	*/	
	
	@Override
	protected Competitor playMatch(Competitor c1, Competitor c2) {
		Competitor gagnant = this.getMatch().consequence(c1,c2);
		gagnant.addPoints(1);
		System.out.println(c1.getName() + " vs " + c2.getName() + " ---> " + gagnant.getName() + " wins! ");
		return gagnant;
		
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

}
