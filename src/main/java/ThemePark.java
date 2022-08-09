import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ThemePark {

    private String name;
    private ArrayList<IReviewed> sections;
    private HashMap<String, Integer> reviews;

    public ThemePark(String name, ArrayList<IReviewed> sections) {
        this.name = name;
        this.sections = sections;
        this.reviews = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void collectReviews() {
        for (IReviewed section:
             this.sections) {
            reviews.put(section.getName(), section.getRating());
        }
    }

    public ArrayList<IReviewed> getSections() {
        return sections;
    }

    public HashMap<String, Integer> getReviews() {
        return reviews;
    }

    public void visit(Visitor visitor, Attraction attraction) {
        if (attraction.isAllowed(visitor)) {
            visitor.addVisit(attraction);
            attraction.incrementVisitCount();
        }
    }

    public ArrayList<IReviewed> getAllowedFor(Visitor visitor) {
        ArrayList<IReviewed> allowedSections = new ArrayList<>();
        for (IReviewed section:
             sections) {
            if (section.isAllowed(visitor)) {
                allowedSections.add(section);
            }
        }
        return allowedSections;
    }
}
