package strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import competition.Competitor;
import type.League;

/**
 * we create a strategy that select only the last players and if needed , add the players before those chosen
 * */
public class SelectLastInLeagues extends SelectionStrategy{

	/**
	 * returns all the players of the different leagues who last  (plus the players before if not power of two) who will play the tournament
	 *@param leagues the rankings
	 *@return the list of players select for the tournament
	 * @throws Exception if not a power of two
	 */
	
    @Override
    public List<Competitor> competitorsForTournament(List<League> leagues) throws Exception{
        List<Competitor> comp = new ArrayList<Competitor>();
        List<Map<Competitor,Integer>> rankings = extracRankings(leagues);
        comp.addAll(competitorsAtNthPosition(rankings,rankings.get(0).size()));
        addCompetitorsUntilPowerOf2(comp, rankings.get(0).size()-1 , rankings, leagues);
        return comp;
      }

	
}

