package comp.test;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import competition.Competitor;

public class CompetitorTest {

	
	public static junit.framework.Test suite(){
        return new junit.framework.JUnit4TestAdapter(CompetitorTest.class);
    }
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void CompetitorTestOk() {
		Competitor p1 = new Competitor("megan",0);
		Competitor p2 = new Competitor("jack",0);
		assertEquals(p1.getPoints(),0);
		assertEquals(p2.getPoints(),0);
		assertFalse(p1.getName().equals(p2.getName()));
		assertTrue(p1.getPoints()==p2.getPoints());
	}
    @Test
	public void AddPointsTestOk() {
		Competitor p1 = new Competitor("megan",0);
		Competitor p2 = new Competitor("jack",0);
		assertEquals(p1.getPoints(),0);
		assertEquals(p2.getPoints(),0);
		p1.addPoints(5);
		assertTrue(p1.getPoints()== 5);
	}
    
    @Test
	public void EqualsTestOk() {
		Competitor p1 = new Competitor("megan",0);
		Competitor p2 = new Competitor("jack",0);
		p1.addPoints(2);
		p2.addPoints(2);
		assertTrue(p1.getPoints() == p2.getPoints());
		
	}
}
