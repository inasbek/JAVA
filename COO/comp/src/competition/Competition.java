/**
 * 
 */
package competition;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import match.Match;
import observer.MatchObserver;
import util.MapUtil;

/**
 * @author bairouk,Bekkouche
 *
 */

/**
 * Creates a Competition
 */
public abstract class Competition {
	
	private final Match match;

	/**
	 * a list of all the competitors
	 */
	protected final List<Competitor> competitors ;
	
	/**
	* Constructs a competition .
	* @param competitors the competitors(players) of this competition .
	* @param match the match that we 're playing
	*/
	
	public Competition(List<Competitor> competitors, Match match) {
		this.match = match;
		this.competitors = competitors;
	}
	
	/**
	* Organizes the matches between the competitors and play them with playMatch.
	* and it can shox an exception
	*@throws Exception if smtng goes wrong
	*/
	
	public void play() throws Exception{
		play(this.competitors);
		ranking();
	}
	
	/**
	* Starts the competition .
	*@param competitors les joueurs dans une liste
	*@throws Exception if smtng goes wrong
	*/
	protected abstract void play(List<Competitor> competitors) throws Exception;
	
	/**
	* Starts the matches between two competitors  .
	*@param c1 the competitor
	*@param c2 the competitor
	*@return winner 
	*/
	//protected abstract Competitor playMatch(Competitor c1,Competitor c2);
	
	protected Competitor playMatch(Competitor c1, Competitor c2) {
		return this.match.play(c1, c2);
	}
	/**
	* Gets the Match .
	* @return the match .
	*
	*/
	public Match getMatch() {
		return this.match;
	}
	
	/**
	 * verify if the param x can be written : h²
	 * @param x int
	 * @return boolean
	 */
	public boolean estPuissanceDe2(long x) {
			return (x != 0) && ((x & (x - 1))==0) ;
			
		}
	
	
	/**
	 * Returns the ranking of competitors in the end of competitions with their points.
	 *@return return the ranking of competitors in the end of competitions with their points .
	 */
	public Map<Competitor, Integer> ranking() {
		Map<Competitor, Integer> ranking = new HashMap<Competitor, Integer>();
		for(Competitor c: competitors){
			ranking.put(c, c.getPoints());}
		return MapUtil.sortByDescendingValue(ranking);
	}
	
	/**
	 * returns the list of the different observers
	 * @return the observers
	 */
	public Collection<MatchObserver> getObserveurs(){
		return this.match.getObserveurs();
	}
	
	/**
	 * add a collection of observers in observers 
	 * @param observers the list to add in observers
	 */
	public void registerr(Collection<MatchObserver> observers) {
		this.match.registerr(observers);
	}
	
	/**
	 * add one observer to the collection observers
	 * @param observer the observer to add in the collection
	 */
	public void setObserver(MatchObserver observer) {
		this.match.register(observer);
	}
	
	
	
}

