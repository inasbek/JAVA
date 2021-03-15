/**
 * 
 */
package observer;

import competition.Competitor;

/**
 * @author bairouk
 *
 */
public interface MatchObserver {

	/**
	 * a method for the observeurs 
	 * @param winner : the winner
	 * @param loser : the loser
	 */
	public void reactToMatch(Competitor winner , Competitor loser);

}
