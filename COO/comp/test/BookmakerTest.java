/**
 * 
 */
package comp.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import competition.Competitor;
import match.Match;
import match.MockMatch;
import observer.Bookmakers;

/**
 * @author bairouk
 *
 */
public class BookmakerTest {
	
	
	public static junit.framework.Test suite(){
        return new junit.framework.JUnit4TestAdapter(BookmakerTest.class);
    }
	
	
	
	@Test
	public void TestCotesAUGMENTER() throws Exception {
		
		
		Map<Competitor, Integer> cotes = new HashMap<Competitor, Integer>();
		List<Competitor> competitors = new ArrayList<Competitor>() ;
		
		int cote = 5;
		
		Bookmakers bkmaker = new Bookmakers(cote);
		
		Competitor c1 = new Competitor("megan",0);
		Competitor c2 = new Competitor("jack",0);

		competitors.add(c1);
		competitors.add(c2);

		
		Match match = new MockMatch();
		match.register(bkmaker);
		
		match.consequence(c1, c2);
		
		bkmaker.reactToMatch(c1, c2);
		
		assertTrue(4 == bkmaker.getCote(c1));
		
		assertTrue(5 == bkmaker.augmenterCote(c1));
		
	}
	
	@Test
	public void TestCotesDIMUNIER() throws Exception {
		
		
		Map<Competitor, Integer> cotes = new HashMap<Competitor, Integer>();
		List<Competitor> competitors = new ArrayList<Competitor>() ;
		
		int cote = 0;
		
		Bookmakers bkmaker = new Bookmakers(cote);
		
		Competitor c1 = new Competitor("megan",0);
		Competitor c2 = new Competitor("jack",0);

		competitors.add(c1);
		competitors.add(c2);

		
		Match match = new MockMatch();
		match.register(bkmaker);
		
		match.consequence(c1, c2);
		
		bkmaker.reactToMatch(c1, c2);
		
		assertTrue(0 == bkmaker.getCote(c1));
		
		assertTrue(0 == bkmaker.dimunierCote(c1));
		
		
		//assertTrue(6 == bkmaker.augmenterCote(c2));

		
		/*String [] names = {"John","Samy"};
		for (String name:names)
	         competitors.add(new Competitor(name));*/
		
		//assertEquals(bkmaker.augmenterCote(c1), 6);
		
	}

	
}
