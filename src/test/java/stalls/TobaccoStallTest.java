package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor charlie;
    Visitor sushi;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", 4, "Jack Jarvis", ParkingSpot.B1);
        charlie = new Visitor(15, 160, 50.00);
        sushi = new Visitor(18, 165, 100.00);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void visitorOver18isAllowedTrue() {
        assertTrue(tobaccoStall.isAllowed(sushi));
    }

    @Test
    public void visitorUnder18isAllowedFalse() {
        assertFalse(tobaccoStall.isAllowed(charlie));
    }
}
