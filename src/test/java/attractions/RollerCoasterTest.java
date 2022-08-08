package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class RollerCoasterTest {

    RollerCoaster rollerCoaster;
    Visitor allison;
    Visitor charlie;
    Visitor sushi;
    Visitor lebron;
    Visitor mary;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10, 8.40);
        allison = new Visitor(12, 150, 30.00);
        charlie = new Visitor(13, 140, 40.00);
        sushi = new Visitor(16, 165, 100.00);
        lebron = new Visitor(37,206,1000.00);
        mary = new Visitor(29, 200, 300);

    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void visitorUnder12ButOver145HeightIsAllowedFalse() {
        assertFalse(rollerCoaster.isAllowed(allison));
    }

    @Test
    public void visitorOver12ButUnder145HeightIsAllowedFalse() {
        assertFalse(rollerCoaster.isAllowed(charlie));
    }

    @Test
    public void visitorOver12AndOver145HeightIsAllowedTrue() {
        assertTrue(rollerCoaster.isAllowed(sushi));
    }

    @Test
    public void chargesDoubleVisitorsOver200Height() {
        assertEquals(16.80, rollerCoaster.priceFor(lebron), 0.01);
    }

    @Test
    public void chargesNormalVisitors200HeightAndLess() {
        assertEquals(8.40, rollerCoaster.priceFor(sushi), 0.01);
        assertEquals(8.40, rollerCoaster.priceFor(mary), 0.01);
    }

    @Test
    public void canIncrementVisitCount() {
        rollerCoaster.incrementVisitCount();
        assertEquals(1, rollerCoaster.getVisitCount());
    }
}
