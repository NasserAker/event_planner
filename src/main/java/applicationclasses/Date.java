package applicationclasses;

import java.util.ArrayList;
import java.util.List;

public class Date {
    private int day;
    private int month;
    private int year;

    private static final List<Date> availableDates = new ArrayList<>();


    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Getters and setters
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }





    public static void initializeAvailableDates() {
        // Add available dates to the Date class
        availableDates.add(new Date(1, 4, 2024));
        availableDates.add(new Date(5, 4, 2024));
        availableDates.add(new Date(10, 4, 2024));
        availableDates.add(new Date(15, 4, 2024));
        availableDates.add(new Date(20, 4, 2024));
        // Add more dates as needed...
    }

    // toString method to print date details
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }




}
