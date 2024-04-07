package applicationclasses;

import java.util.ArrayList;
import java.util.List;

public class Venue {
    private String name;
    private String location;
    private int capacity;
    private double cost;


    public double getCost() {
        return cost;
    }

    public Venue(String name, String location, int capacity, double cost) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.cost = cost;
    }


    private static final List<Venue> availableVenues = new ArrayList<>();

    // Getters and setters




    public int getCapacity() {
        return capacity;

    }


    public static void initializeAvailableVenues() {
        // Add available dates to the Date class

        availableVenues.add(new Venue("Moon", "Nablus", 100, 1500.0));

        availableVenues.add(new Venue("Sun", "Ramallah", 150, 2000.0));
        availableVenues.add(new Venue("Star", "Jenin", 200, 2500.0));
        availableVenues.add(new Venue("Sky", "Hebron", 120, 1800.0));
        availableVenues.add(new Venue("Space", "Jerusalem", 120, 1800.0));


    }

    public static List<Venue> getAvailableVenues() {

        return availableVenues;
    }

    public static void addVenueToTheList(Venue venue) {
        availableVenues.add(venue);
    }


    @Override
    public String toString() {
        return STR."Name: '\{name}\{'\''}, Location: '\{location}\{'\''}, Capacity: \{capacity} people, Cost: $\{cost}";
    }

    public String getName() {return name;
    }

    public String getLocation() { return location;
    }
}