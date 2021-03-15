package comp.test;
import static org.junit.Assert.*;


import org.junit.Test;

import competition.Competitor;
import match.Match;

public abstract class MatchTest {
	
	

	
	protected abstract Match createMatch ();
	
	
    /** test consequence when it works */

	@Test
	public void RandomWinn() {
		Competitor c1 = new Competitor("jean",0);	
		Competitor c2 = new Competitor("mike",0);
		Match match = createMatch();

		assertTrue("jean" == match.consequence(c1,c2).getName());
	}

}
