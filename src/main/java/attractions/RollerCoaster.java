package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster extends Attraction implements ISecurity, ITicketed {

    public RollerCoaster(String name, int rating, double price) {
        super(name, rating, price);
    }

    public boolean isAllowed(Visitor visitor) {
        if(visitor.getAge() > 12 && visitor.getHeight() > 145) {
            return true;
        }
        return false;
    }

    public double priceFor(Visitor visitor) {
        if (visitor.getHeight() > 200.00) {
            return getPrice() * 2;
        }
        return getPrice();
    }
}
