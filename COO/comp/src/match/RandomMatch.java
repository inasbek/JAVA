package match;

import java.util.Random;

import competition.Competitor;

/**
 * 
 * creates a match where the winner is being chosen randomly
 */
public class RandomMatch extends Match{

	/**
	 * Returns the random winner of the match 
	 * @return Return the winner of the match randomly
	 * @param  c1 the first competitor of the match
	 * @param  c2 the second competitor of the match
	 */	
	public Competitor consequence(Competitor c1, Competitor c2) {
	    Random rand = new Random();
	    int randomindice = rand.nextInt(2);
	    if (randomindice == 0) {
	    	return c1;
	    	}
	    
	    else {
	    	return c2;
	    }
	}
	
	
	
	
}
