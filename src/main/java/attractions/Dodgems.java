package attractions;

import behaviours.ITicketed;
import people.Visitor;

public class Dodgems extends Attraction implements ITicketed {

    public Dodgems(String name, int rating, double price) {
        super(name, rating, price);
    }

    public double priceFor(Visitor visitor) {
        if (visitor.getAge() < 12) {
            return getPrice() / 2;
        }
        return getPrice();
    }
}
