package attractions;

import behaviours.ISecurity;
import people.Visitor;

public class Playground extends Attraction implements ISecurity {

    public Playground(String name, int rating, double price) {
        super(name, rating, price);
    }

    public boolean isAllowed(Visitor visitor) {
        if (visitor.getAge() > 15) {
            return false;
        }
        return true;
    }
}
