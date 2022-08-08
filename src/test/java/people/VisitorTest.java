package people;

import attractions.Park;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    Visitor visitor;
    Park park;

    @Before
    public void before(){
        visitor = new Visitor(14, 1.2, 40.0);
        park = new Park("Park", 4, 5.00);
    }

    @Test
    public void hasAge() {
        assertEquals(14, visitor.getAge());
    }

    @Test
    public void hasHeight() {
        assertEquals(1.2, visitor.getHeight(), 0.1);
    }

    @Test
    public void hasMoney() {
        assertEquals(40.0, visitor.getMoney(), 0.1);
    }

    @Test
    public void hasEmptyVisitedAttractions() {
        assertEquals(0, visitor.getVisitedAttractions().size());
    }

    @Test
    public void canAddVisit() {
        visitor.addVisit(park);
        assertEquals(1, visitor.getVisitedAttractions().size());
    }
}
