import attractions.Dodgems;
import attractions.Playground;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    ThemePark wonderland;
    Dodgems bumpy;
    RollerCoaster rockAndRoll;
    CandyflossStall candyCrush;
    TobaccoStall smokey;
    ArrayList<IReviewed> sections;
    Visitor sushi;
    Playground playground;

    @Before
    public void before() {
        bumpy = new Dodgems("Bumpy", 4, 5.50);
        rockAndRoll = new RollerCoaster("Rock & Roll", 3, 12.00);
        candyCrush = new CandyflossStall("Candy Crush", 5, "Sushi", ParkingSpot.A3);
        smokey = new TobaccoStall("Smokey", 2, "Charlie", ParkingSpot.A1);
        playground = new Playground("Playground", 4, 5);
        sections = new ArrayList<>(Arrays.asList(bumpy, rockAndRoll, candyCrush, smokey, playground));
        wonderland = new ThemePark("WonderLand", sections);
        sushi = new Visitor(21, 170, 80);
    }

    @Test
    public void hasName() {
        assertEquals("WonderLand", wonderland.getName());
    }

    @Test
    public void hasSections() {
        assertEquals(5, wonderland.getSections().size());
    }

    // visit function should add the attraction to visitors' list and increment visit count of attraction
    @Test
    public void canVisit() {
        wonderland.visit(sushi, rockAndRoll);
        assertEquals(1, sushi.getVisitedAttractions().size());
    }
    @Test
    public void canCollectReviews() {
        wonderland.collectReviews();
        assertEquals(wonderland.getSections().size(), wonderland.getReviews().size());
    }

    @Test
    public void canGetAllAllowedFor() {
        Visitor allison = new Visitor(10, 120, 30);
        sushi = new Visitor(21, 170, 80);
        assertEquals(3, wonderland.getAllowedFor(allison).size());
        assertEquals(4, wonderland.getAllowedFor(sushi).size());
    }
}
