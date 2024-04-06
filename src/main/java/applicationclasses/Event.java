package applicationclasses;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private String eventName;
    private int price;
    private int availability;
    private String description;
    private String location;
    private int time;


    private static ArrayList<Event> allEvents = new ArrayList<>();


    public Event(String eventName, int price, int availability, String description, String location, int time){
        this.eventName = eventName;
        this.price = price;
        this.availability = availability;
        this.description = description;
        this.location = location;
        this.time = time;
    }

    public Event() {
        this("", 0, 0, "", "", 0);
    }


    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setTime(int time) {
        this.time = time;
    }
    public int getTime() {
        return time;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    public static void initializeEvents() {
        Event event1 = new Event("Event1", 100, 50, "Description 1", "Location 1", 10);
        Event event2 = new Event("Event2", 150, 30, "Description 2", "Location 2", 12);

        allEvents.add(event1);
        allEvents.add(event2);

    }

    public static void addEvent(Event event) {
        allEvents.add(event);
    }

    public static List<Event> getAllEvents() {
        return allEvents;
    }


}
