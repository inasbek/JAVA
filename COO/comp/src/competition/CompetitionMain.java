/**
 * 
 */
package competition;

import java.util.ArrayList;
import java.util.List;

import match.Match;
import match.MockMatch;
import match.RandomMatch;
import observer.Bookmakers;
import observer.Journalist;
import type.League;
import type.Master;
import type.Tournament;
import strategy.*;

/**
 * @author bairouk
 *
 */



/** Class that executes the game Competition using the classes 
 * in the packages util and comp.match and type
 * @author  Bairouk  , Bekkouche
 * @version 1.0 
 */
public class CompetitionMain {

	
    /** this method executes the classes in the packages Competition and type and util 
     * */
	
	/**
	 * @param args some args
	 * @throws Exception if it doesnt work
	 */
	public static void main(String[] args) throws Exception {
		List<Competitor> competitors = new ArrayList<Competitor>() ;
		String [] names = {"John","Samy"};
		for (String name:names)
	         competitors.add(new Competitor(name));
		
		/*Competitor c1 = new Competitor("A",0);
		Competitor c2 = new Competitor("B",0);
		Competitor c3 = new Competitor("C",0);
		Competitor c4 = new Competitor("D",0);

		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		competitors.add(c4);
		
		Competitor c5 = new Competitor("E",0);
		Competitor c6 = new Competitor("F",0);
		Competitor c7 = new Competitor("J",0);
		Competitor c8 = new Competitor("H",0);
		
		competitors.add(c5);
		competitors.add(c6);
		competitors.add(c7);
		competitors.add(c8);
		
		Competitor c15 = new Competitor("I",0);
		Competitor c61 = new Competitor("hF",0);
		Competitor c73 = new Competitor("Jh",0);
		Competitor c87 = new Competitor("hH",0);
		
		competitors.add(c15);
		competitors.add(c61);
		competitors.add(c73);
		competitors.add(c87);*/
		
		System.out.println("####- League -####\n");
		Match match = new RandomMatch();
		match.register(new Journalist());
		match.register(new Bookmakers(5));
		Competition league = new League(competitors , match);
		league.play();
		
	/*	Competition tournament = new Tournament(competitors , new RandomMatch());
		System.out.println("\n\n\n####- Tournament -####\n");
		tournament.play();*/
		
		
		/*int nmbreOfLeagues = 3;
		System.out.println("\n\n\nThe number of players : " + competitors.size());
		System.out.println("The number of players in each leagues : " + competitors.size()/nmbreOfLeagues);
		Competition master = new Master(competitors , new RandomMatch(),new SelectLastInLeagues(),nmbreOfLeagues);
		System.out.println("\n\n\n####- Master -####\n");
		master.play();*/
		


	}

}
