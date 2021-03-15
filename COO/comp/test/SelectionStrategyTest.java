package comp.test;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import competition.Competition;
import competition.Competitor;

public abstract class SelectionStrategyTest {

	protected final List<Competitor> competitors = null;
	protected abstract Competition createCompetition (List<Competitor> competitors) throws Exception;
	protected abstract Competition createCompetition2 (List<Competitor> competitors) throws Exception;

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
		
		Competitor c5 = new Competitor("A",0);
		Competitor c6 = new Competitor("B",0);
		Competitor c7 = new Competitor("C",0);
		Competitor c8 = new Competitor("D",0);
		
		competitors.add(c5);
		competitors.add(c6);
		competitors.add(c7);
		competitors.add(c8);
		
		Competition competition = createCompetition(competitors);

		assertTrue(competitors.contains(c1));
		System.out.println("\n**************TEST1****************");
		competition.play();
	}
	
	@Test
	public void CompetitionTestKO() throws Exception {
		try {
			List<Competitor> competitors = new ArrayList<Competitor>() ;
			Competitor c1 = new Competitor("megan",0);
			Competitor c2 = new Competitor("jack",0);
			Competitor c3 = new Competitor("zara",0);
			Competitor c4 = new Competitor("joe",0);

			competitors.add(c1);
			competitors.add(c2);
			competitors.add(c3);
			competitors.add(c4);
			
			Competitor c5 = new Competitor("A",0);
			Competitor c6 = new Competitor("B",0);
			Competitor c7 = new Competitor("C",0);
			Competitor c8 = new Competitor("D",0);
			
			competitors.add(c5);
			competitors.add(c6);
			competitors.add(c7);
			competitors.add(c8);
			
			Competitor c9 = new Competitor("x",0);
			Competitor c10 = new Competitor("y",0);
			Competitor c11 = new Competitor("z",0);
			Competitor c12 = new Competitor("w",0);
			
			competitors.add(c9);
			competitors.add(c10);
			competitors.add(c11);
			competitors.add(c12);
			
			Competition competition = createCompetition2(competitors);

			assertTrue(competitors.contains(c1));
			System.out.println("\n\n**************************TEST2************************");
			competition.play();
		}
		catch (Exception e){
			System.err.format(" error: %s%n", e);
			System.out.println("\n");
		}
		
	}	

	
	
}
