package comp.test;
import java.util.List;

import type.League;
import competition.Competition;
import competition.Competitor;
import match.RandomMatch;

public class LeagueTest extends CompetitionTest {

	public static junit.framework.Test suite(){
        return new junit.framework.JUnit4TestAdapter(LeagueTest.class);
    }
	
	@Override
	public Competition createCompetition(List<Competitor> competitors) {
		return new League(competitors , new RandomMatch()) ;
	}
	
	

	
}
