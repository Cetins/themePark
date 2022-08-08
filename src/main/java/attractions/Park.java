package attractions;

import people.Visitor;

public class Park extends Attraction {

    public Park(String name, int rating, double price) {
        super(name, rating, price);
    }

    public boolean isAllowed(Visitor visitor) {
        return true;
    }
}
