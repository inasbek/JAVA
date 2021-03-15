package comp.test;
import match.Match;
import match.MockMatch;

public class MockMatchTest extends MatchTest{

	public static junit.framework.Test suite(){
        return new junit.framework.JUnit4TestAdapter(MockMatchTest.class);
    }
	
	public Match createMatch() {
		return new MockMatch() ;
	}

	
	
	
}