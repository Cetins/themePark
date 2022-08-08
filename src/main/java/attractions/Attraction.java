package attractions;
import behaviours.IReviewed;

public abstract class Attraction implements IReviewed {
    private String name;
    private int rating;
    private int visitCount;
    private double price;

    public Attraction(String name, int rating, double price) {
        this.name = name;
        this.rating = rating;
        this.visitCount = 0;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public double getPrice() {
        return price;
    }

    public void incrementVisitCount() {
        this.visitCount += 1;
    }
}
