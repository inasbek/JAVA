package type;

import java.util.ArrayList;
import java.util.List;

import competition.Competition;
import competition.Competitor;
import match.Match;
import strategy.SelectionStrategy;

/**
 * @author bairouk,Bekkouche
 *
 */

/**
 * Creates a Master
 */
public class Master extends Competition {
	private SelectionStrategy selection;
	private int nbLeagues;
 

	/**
	 * Constructor of the class Master
	 *@param competitors the list of the competitors of the Master
	 *@param match the match played
	 *@param selection the strategy chosen to played the tournament
	 *@param nbLeagues : the number of leagues that we wants
	 * @throws Exception if we van't divided the players by the nbLeagues
	 */
	
	public Master(List<Competitor> competitors, Match match, SelectionStrategy selection , int nbLeagues) throws Exception{
		 super(competitors, match);
		 this.selection=selection;
		 this.nbLeagues = nbLeagues;
		 if (competitors.size() % nbLeagues != 0) {
				throw new Exception("the number of players can't be divided in "+this.nbLeagues + " Leagues");
			}
		 
	 }
	
	/**
	 * returns the number of leagues played in the Master
	 *@return the number of leagues
	 */
	public int getNbLeagues() {
		return this.nbLeagues;
	}

	/**
	 * play the different leagues and the tournament
	 *@param competitors the list of the competitors 
	 *@throws Exception if the number of player in the tournament is not a power of two
	 */
	
	 protected void play(List<Competitor> competitors) throws Exception{
	
		 List<League> leagues = new ArrayList<League>();
	
	 //on joue la league
		 System.out.println(" %%%%%% LEAGUE %%%%%% \n\n");
		 leagues = playLeagues();
		 
		 //faut choisir les joueurs qu'on va mettre dans tournament
		 List<Competitor> competitorsTourn = selection.competitorsForTournament(leagues); 
	
	 //on joue le tournoi
		 System.out.println("\n\n %%%%%% TOURNAMENT %%%%%% \n\n");
	 	playTournament(competitorsTourn);
	 }
	 
	 /**
		 *plays the different leagues
		 *@throws Exception if the number of player is not a power of two
		 *@return all the rankings of all the leagues in a list
		 */
	 
	 private List<League> playLeagues() throws Exception {
		 List<League> leagues = new ArrayList<League>();		 		 
		 for(int i = 1; i <= nbLeagues ; i++) {
			 //jessaye avec this ou super juste pour savoir
			 int beginning = (competitors.size()/nbLeagues)*(i-1);
			 int end = (competitors.size()/nbLeagues)*i;
			 List<Competitor> subComp = competitors.subList(beginning, end);
			 
			 League league = new League(subComp, this.getMatch());
			 league.play();
			 
			 leagues.add(league);
			 System.out.println("\n\n\n");
		 }
		 return leagues;
	 }
	 
	 /**
		 *plays the tournament 
		 *@param compTournament the list of the competitors of the Tournament
		 *@throws Exception if the number of player is not a power of two
		 */
	 private void playTournament(List<Competitor> competitorsTourn) throws Exception {
	 //on vérifie que le nombre de joueurs pour le tournoi est une puissance de deux sinon on ajoute des joueurs
		 for (Competitor c: competitorsTourn) {
			 c.setPoints(0);
		 }
		 //on joue le tournoi
		 Tournament tournoi = new Tournament(competitorsTourn, this.getMatch());
		 tournoi.play();
	 }
	 
	
	 /**
	 * Starts the matches between two competitors and prints the winner .
	 * @param c1 the first competitor
	 * @param c2 the second competitor
	 * @return the winner
	 */
	 @Override
	 protected Competitor playMatch(Competitor c1, Competitor c2) {
		 return null;
	
	 }
	
}
