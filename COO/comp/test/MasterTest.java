package comp.test;
import java.util.List;

import competition.Competition;
import competition.Competitor;
import match.RandomMatch;
import strategy.SelectFirstInLeagues;
import type.Master;

public class MasterTest extends CompetitionTest {

	public static junit.framework.Test suite(){
        return new junit.framework.JUnit4TestAdapter(MasterTest.class);
    }

	@Override
	protected Competition createCompetition(List<Competitor> competitors) throws Exception{
	
		return new Master(competitors, new RandomMatch(),new SelectFirstInLeagues(), 2);
	}

}
