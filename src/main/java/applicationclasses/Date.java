package applicationclasses;

import java.util.ArrayList;
import java.util.List;

public class Date {
    private int day;
    private int month;
    private int year;

    protected static final List<Date> availableDatesV1 = new ArrayList<>();
    protected static final List<Date> availableDatesV2 = new ArrayList<>();
    protected static final List<Date> availableDatesV3 = new ArrayList<>();
    protected static final List<Date> availableDatesV4 = new ArrayList<>();
    protected static final List<Date> availableDatesV5 = new ArrayList<>();



    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }


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

        availableDatesV1.add(new Date(1, 4, 2024));
        availableDatesV1.add(new Date(5, 4, 2024));
        availableDatesV1.add(new Date(10, 4, 2024));
        availableDatesV1.add(new Date(15, 4, 2024));
        availableDatesV1.add(new Date(20, 4, 2024));

        availableDatesV2.add(new Date(2, 4, 2024));
        availableDatesV2.add(new Date(6, 4, 2024));
        availableDatesV2.add(new Date(11, 4, 2024));
        availableDatesV2.add(new Date(16, 4, 2024));
        availableDatesV2.add(new Date(21, 4, 2024));

        availableDatesV3.add(new Date(3, 4, 2024));
        availableDatesV3.add(new Date(7, 4, 2024));
        availableDatesV3.add(new Date(12, 4, 2024));
        availableDatesV3.add(new Date(17, 4, 2024));
        availableDatesV3.add(new Date(22, 4, 2024));

        availableDatesV4.add(new Date(4, 4, 2024));
        availableDatesV4.add(new Date(8, 4, 2024));
        availableDatesV4.add(new Date(13, 4, 2024));
        availableDatesV4.add(new Date(18, 4, 2024));
        availableDatesV4.add(new Date(23, 4, 2024));


        availableDatesV5.add(new Date(5, 4, 2024));
        availableDatesV5.add(new Date(9, 4, 2024));
        availableDatesV5.add(new Date(14, 4, 2024));
        availableDatesV5.add(new Date(19, 4, 2024));
        availableDatesV5.add(new Date(24, 4, 2024));


    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }




}
