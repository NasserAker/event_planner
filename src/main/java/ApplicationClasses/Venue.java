package ApplicationClasses;

public class Venue {
    private String name;
    private String location;

    private int capacity;

    public Venue(String name, String location, int capacity) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
    }

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

    // toString method to print venue details
    @Override
    public String toString() {
        return "Venue{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }


}
