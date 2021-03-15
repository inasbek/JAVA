/**
 * 
 */
package match;

import java.util.Collection;
import java.util.HashSet;
import competition.Competitor;
import observer.MatchObserver;

/**
 * @author bairouk,Bekkouche
 *
 */


/**
 * 
 * creates the match
 */
public abstract class Match {

	/**
	 * we create a methode that adds points or in general choice the player 
	 * @param c1 : a Competitor
	 * @param c2 : a Competitor
	 * @return Competitor : it returns the competitor
	 */
	public abstract Competitor consequence(Competitor c1 , Competitor c2);

	/**
	 * we create a liste of all the obervers 
	 */
	protected Collection<MatchObserver> observeurs = new HashSet<MatchObserver>();

	/**
	 * @return winner : the winner of the match
	 * @param c1 : a player
	 * @param c2 : a player
	 */
	
	public Competitor play(Competitor c1 , Competitor c2) {
		//displayCompetitors(c1,c2);
		Competitor winner = consequence(c1, c2) ;
		//displayWinner(winner);
		Competitor loser = ((winner != c1) ? c1 : c2);
		
		for (MatchObserver obs : this.observeurs) {
			obs.reactToMatch(winner, loser);
		}
		return winner ;
		
	}

	/**
	 * prints the winner
	 * @param winner : a player
	 * 
	 * */
	public void displayWinner(Competitor winner) {
		System.out.println(" ---> " + winner.getName() + " wins \n");
	}

	 /**
	  *  prints each player with his adversaire
	  * @param c1 : a player
	  * @param c2 : a player
	  */
	public void displayCompetitors(Competitor c1, Competitor c2) {
		System.out.println(c1.getName() + " vs " + c2.getName());

	}	
	
	/**
	  *  return the all the obseervers, pour savoir s il y a des bookmakers et les journalistes
	  *  @return the observeurs 
	  */
	public Collection<MatchObserver> getObserveurs() {
		return this.observeurs;
	}
	
	/**
	  *  adds the observer dans la liste des observeurs
	  * @param observer : a observer
	  */
	public void register(MatchObserver observer) {
		observeurs.add(observer);		
	}
	
	/**
	  *  adds all the observers dans la liste des observeurs
	  * @param observeurs : a observer
	  */
	public void registerr(Collection<MatchObserver> observeurs) {
		this.observeurs = observeurs;
	}
	
	/**
	  *  delete the observer dans la liste des observeurs
	  * @param observer : a observer
	  */
	public void unRegister(MatchObserver observer) {
		this.observeurs.remove(observer);
	}

}
