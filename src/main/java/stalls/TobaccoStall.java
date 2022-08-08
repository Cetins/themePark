package stalls;

import behaviours.ISecurity;
import people.Visitor;

public class TobaccoStall extends Stall implements ISecurity {

    public TobaccoStall(String name, int rating, String ownerName, ParkingSpot parkingSpot) {
        super(name, rating, ownerName, parkingSpot);
    }

    public boolean isAllowed(Visitor visitor) {
        if (visitor.getAge() < 18 ) {
            return false;
        }
        return true;
    }
}
