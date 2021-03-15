package strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import competition.Competitor;
import type.League;

/**
 * we create a strategy that take the best in a rankings , which mean the first and the second but if needed the next 
 * */
public class SelectFstSndInLeagues extends SelectionStrategy{

	/**
	 * returns all the players of the different leagues who first and second (plus next best players if not power of two) who will play the tournament
	 *@param leagues the rankings
	 *@return the list of players select for the tournament
	 * @throws Exception if not a power of two
	 */
	
  public List<Competitor> competitorsForTournament(List<League> leagues) throws Exception{
      List<Competitor> comp = new ArrayList<Competitor>();
      List<Map<Competitor,Integer>> rankings = extracRankings(leagues);
      //dans comp on ajoute les deux premiers de chaque league
      comp.addAll(competitorsAtNthPosition(rankings,1));
      comp.addAll(competitorsAtNthPosition(rankings,2));
      addCompetitorsUntilPowerOf2(comp, 3, rankings, leagues);
      return comp;
  }
  
  
}

