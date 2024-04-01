package ApplicationClasses;

import java.util.ArrayList;
import java.util.List;

public class Venue {
    private String name;
    private String location;

    private int capacity;
    private double cost; // New field for the cost
    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public Venue(String name, String location, int capacity , double cost) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.cost = cost;
    }

    // ArrayList to store available venues
    private static final List<Venue> availableVenues = new ArrayList<>();
    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public void setCapacity(int capacity){
        this.capacity=capacity;
    }

    public int getCapacity(){
        return capacity;

    }



    public static void initializeAvailableVenues() {
        // Add available dates to the Date class

        availableVenues.add(new Venue("Moon", "Address 1", 100, 1500.0));

        availableVenues.add(new Venue("Sun", "Address 2", 150, 2000.0));
        availableVenues.add(new Venue("Star", "Address 3", 200 , 2500.0));
        availableVenues.add(new Venue("Sky", "Address 4", 120, 1800.0));
        availableVenues.add(new Venue("Space", "Address 4", 120 , 1800.0));

        // Add more dates as needed...
    }

    public static List<Venue> getAvailableVenues() {

        return availableVenues;
    }

    public static void addVenueToTheList(Venue venue){
        availableVenues.add(venue);
    }

    // toString method to print venue details
    @Override
    public String toString() {
        return
                "Name:'" + name + '\'' +
                ", Location:'" + location + '\'' +
                ", Cost: $" + cost
                ;
    }


}
