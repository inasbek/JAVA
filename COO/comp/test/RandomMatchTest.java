package comp.test;
import match.Match;
import match.RandomMatch;

public class RandomMatchTest extends MatchTest{
	
	
	public static junit.framework.Test suite(){
        return new junit.framework.JUnit4TestAdapter(RandomMatchTest.class);
    }
	
	public Match createMatch() {
		return new RandomMatch() ;
	}

	
	
	
}
