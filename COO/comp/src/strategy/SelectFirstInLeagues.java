/**
 * 
 */
package strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import competition.Competitor;
import type.League;

/**
 * @author bairouk, bekkouche
 *
 */

/**
 * we create a strategy that take only the first players in a rankings
 */
public class SelectFirstInLeagues extends SelectionStrategy{

	/**
	 * returns all the players of the different leagues who first (plus next best players if not power of two) who will play the tournament
	 *@param leagues the rankings
	 *@return the list of players select for the tournament
	 * @throws Exception if not a power of two
	 */
	

	@Override
	public List<Competitor> competitorsForTournament(List<League> leagues) throws Exception {
		List<Competitor> comp = new ArrayList<Competitor>();
		List<Map<Competitor,Integer>> rankings = extracRankings(leagues);
		comp.addAll(competitorsAtNthPosition(rankings,1));
		addCompetitorsUntilPowerOf2(comp, 2, rankings, leagues);
		return comp;
	}

}
