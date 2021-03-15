package match;

import competition.Competitor;


/**
 * une classe qui force un joueur à gagner
 * et c'est souvent c1
 */
 public class MockMatch extends Match{

		// on va forcer un joueur a gagner
		
/**
 * on force un joueur à gagner
 * @param c1 : a competitor
 * et c'est souvent c1
 */
	@Override
	public Competitor consequence(Competitor c1, Competitor c2) {
		//c1.addPoints(1);
		return c1;
	}

}
