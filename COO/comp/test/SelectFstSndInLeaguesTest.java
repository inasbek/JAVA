package comp.test; 
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import competition.Competition;
import competition.Competitor;
import match.RandomMatch;
import strategy.SelectFstSndInLeagues;
import type.Master;

public class SelectFstSndInLeaguesTest extends SelectionStrategyTest{

	public static junit.framework.Test suite(){
        return new junit.framework.JUnit4TestAdapter(SelectFstSndInLeaguesTest.class);
    }

		@Override
	protected Competition createCompetition(List<Competitor> competitors) throws Exception {
		return new Master(competitors , new RandomMatch(),new SelectFstSndInLeagues() , 2);
	}

		@Override
		protected Competition createCompetition2(List<Competitor> competitors) throws Exception {
			return new Master(competitors , new RandomMatch(),new SelectFstSndInLeagues() , 3);
		}

		@Test
		public void NotEnoughPlayerToPowerOfTwo() throws Exception {
			System.out.println("\n\n\nTEST 3\n\n");
			System.out.println("  %%%%%%%%%%%%MASTER%%%%%%%%%%%% \n");
			List<Competitor> comp = new ArrayList<Competitor>();
			Competitor c1 = new Competitor("A", 0);
			Competitor c2 = new Competitor("B", 0);
			Competitor c3 = new Competitor("C", 0);
			Competitor c4 = new Competitor("D", 0);
			Competitor c5 = new Competitor("E", 0);
			Competitor c6 = new Competitor("F", 0);
			comp.add(c1);
			comp.add(c2);
			comp.add(c3);
			comp.add(c4);
			comp.add(c5);
			comp.add(c6);
			Competition c = createCompetition2(comp);
			try {
				c.play();
			}catch(Exception e) {
				System.err.format("error => %s \n\n", e);
			}
		}
		
}
