package comp.test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import type.Tournament;
import competition.Competition;
import competition.Competitor;
import match.RandomMatch;

public class TournamentTest extends CompetitionTest{
	
	public static junit.framework.Test suite(){
        return new junit.framework.JUnit4TestAdapter(TournamentTest.class);
    }

	@Override
	public Competition createCompetition(List<Competitor> competitors) {
		return new Tournament(competitors , new RandomMatch()) ;
	}
	
	
	@Test(expected = Exception.class)
	public void TournamentTestKO() throws Exception {
		List<Competitor> competitors = new ArrayList<Competitor>() ;
		Tournament tournament = new Tournament(competitors , new RandomMatch()) ;
		Competitor c1 = new Competitor("megan",0);
		Competitor c2 = new Competitor("jack",0);
		Competitor c3 = new Competitor("fati",0);
		
		
		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		
		assertTrue(competitors.contains(c1));
		tournament.play();
		
		
	}

}
