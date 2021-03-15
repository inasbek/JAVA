/**
 * 
 */
package strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import competition.*;
/**
 * @author bairouk
 *
 */
import type.League;
import util.MapUtil;

/**
 * Creates a SelectionStrategy
 */
public abstract class SelectionStrategy {
	/**
	 * we create a list with all the cometitors that will play the tournament
	 * @param leagues : a list of all the leagues
	 * @return list de competitors in the tournament
	 * @throws Exception : if there isnt enough players for tournament
	 */
	public abstract List<Competitor> competitorsForTournament(List<League> leagues) throws Exception;
	
	/**
	* it returns all the rankings of the leagues
	* @param leagues : a list of all the  leagues
	* @return rankings : the final tanking
	*/
	
	protected List<Map<Competitor,Integer>> extracRankings(List<League> leagues){
        List<Map<Competitor,Integer>> rankings = new ArrayList<Map<Competitor,Integer>>();
        for (League league:leagues){
            rankings.add(league.ranking());
        }
        return rankings;
      }
	
	/**
	* it sorts the list of players
	* @param rankings : the ranking of the players , sorted.
	* @param position : the position of the player
	* @return a list of the competitors in a position
	*/
	
	protected List<Competitor> competitorsAtNthPosition(List<Map<Competitor,Integer>> rankings, int position){
        Map<Competitor,Integer> competitors = new HashMap<Competitor,Integer>();
        for (Map<Competitor,Integer> map : rankings){
            Entry<Competitor, Integer> entry = getEntryAtNthPosition(map, position);
            competitors.put(entry.getKey(), entry.getValue());
        }
        Map<Competitor,Integer> sortedList = MapUtil.sortByDescendingValue(competitors);

        List<Competitor> result = new ArrayList<Competitor>(sortedList.keySet());
        return result;
    }
	

	/**
	* it sorts the list of players
	* @param map :the list of competitors(players) of this competition .
	* @param n : 
	* une fontion auxiliaire
	* 	*/
	
    private Entry<Competitor, Integer> getEntryAtNthPosition(Map<Competitor, Integer> map, int n) {
        int i = 1;
        for (Entry<Competitor, Integer> entry : map.entrySet()) {
            if (i== n){
                return entry;
            }
            i++;
        }
        return null;

    }
    
    
    /**
	* it sorts the list of players
	* @param list :the list of competitors(players) of this competition .
	* it doesn't return anything , but it sort the list given using the function compare
	*/
    
    private void sort(List<Competitor> list) {
        Collections.sort(list,new Comparator<Competitor>() {
            
            public int compare(Competitor c1,Competitor c2) {
                if (c1.getPoints() > c2.getPoints()) {
                    return 1;
                } 
                else if (c1.getPoints() < c2.getPoints()) {
                  return -1;
                }
                else
                  return 0;
      }});
    
    }
    
    /**
	* it adds players until the size of competitors is power of TWO 
	* @param comp :the list of competitors(players) of this competition .
	* @param n : the positions of players in the ranking
	* @param rankings  : the ranking of the player , sorted
	* @param leagues : the league that contains players
	* @throws Exception ; if there is no more players to add
	*/
    
    protected void addCompetitorsUntilPowerOf2(List<Competitor> comp, int n ,List<Map<Competitor,Integer>> rankings, List<League> leagues) throws Exception{
    	try {
    		List<Competitor> next = competitorsAtNthPosition(rankings,n);
    		sort(next);
    		Collections.reverse(next);
    		int p = 0;
    		while(!leagues.get(0).estPuissanceDe2(comp.size())) {
    			if (p == next.size()) {
    				next = competitorsAtNthPosition(rankings,++n);
    			}
    			else {
    				comp.add(next.get(p));
    				p++;
    			}
    		}
    		
    		
    	}
    	catch(Exception e) {
    		throw new Exception(comp.size() + " : the number  of players must be a power of two. \n ") ;
    	}
    	
    	
    }


}
