package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;
    Visitor charlie;
    Visitor sushi;
    Visitor ellen;

    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("Bumper Cars", 5, 5.80);
        charlie = new Visitor(13, 140, 30);
        sushi = new Visitor(9, 90, 20);
        ellen = new Visitor(12, 110, 25);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }

    @Test
    public void chargesHalfPriceVisitorsUnder12() {
        assertEquals(2.90, dodgems.priceFor(sushi), 0.01);
    }

    @Test
    public void chargesNormalPriceVisitors12AndOver() {
        assertEquals(5.80, dodgems.priceFor(charlie), 0.01);
        assertEquals(5.80, dodgems.priceFor(ellen), 0.01);
    }

    @Test
    public void canIncrementVisitCount() {
        dodgems.incrementVisitCount();
        assertEquals(1, dodgems.getVisitCount());
    }
}
