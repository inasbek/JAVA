package comp.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import competition.Competition;
import competition.Competitor;

public abstract class CompetitionTest {
	
	public static junit.framework.Test suite(){
        return new junit.framework.JUnit4TestAdapter(CompetitionTest.class);
    }
	
	protected final List<Competitor> competitors = null;
	protected abstract Competition createCompetition (List<Competitor> competitors) throws Exception;
	
	

	@Test
	public void CompetitionTestOK() throws Exception {
		List<Competitor> competitors = new ArrayList<Competitor>() ;
		Competitor c1 = new Competitor("megan",0);
		Competitor c2 = new Competitor("jack",0);
		Competitor c3 = new Competitor("zara",0);
		Competitor c4 = new Competitor("joe",0);

		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		competitors.add(c4);
		Competition competition = createCompetition(competitors);

		assertTrue(competitors.contains(c1));
		competition.play();
	}

	
	
}
