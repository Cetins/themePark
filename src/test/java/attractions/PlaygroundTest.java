package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class PlaygroundTest {
    Playground playground;
    Visitor allison;
    Visitor charlie;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7, 12.00);
        allison = new Visitor(12, 120, 30.00);
        charlie = new Visitor(16, 160, 40.00);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void visitorOver15IsAllowedFalse() {
        assertFalse(playground.isAllowed(charlie));
    }

    @Test
    public void visitorUnder15IsAllowedTrue() {
        assertTrue(playground.isAllowed(allison));
    }

    @Test
    public void canIncrementVisitCount() {
        playground.incrementVisitCount();
        assertEquals(1, playground.getVisitCount());
    }
}

