package ApplicationClasses;

import java.util.ArrayList;
import java.util.List;

import static ApplicationClasses.Date.*;
import static ApplicationClasses.ServiceProvider.logger;
import static ApplicationClasses.User.*;
import static Main.ProductionCode.*;


public class Operations {


    public static boolean addUser(User c) {
        boolean add=true;
        for(int i = 0; i< User.getUserList().size() ; i++) {
            if((getEmail().equals(getEmail()))||((getEmail().equals(getEmail())) && (getUsername().equals(getUsername())) && (getAddress().equals(getAddress()))&& (getPhone().equals(getPhone()))))
            {
                add = false;
                break;
            }
        }
        if(add) {
            User.getUserList().add(c);
        }
        return add;
    }

    public static void createAccountPage()
    {

        logger.info("Enter your Email:");
        String email = input.nextLine();
        logger.info("Enter your username:");
        String username = input.nextLine();
        logger.info("Enter your Gender : ");
        String gen = input.nextLine();
        logger.info("Enter your Phone number:");
        String phnum = input.nextLine();
        logger.info("Enter your Address:");
        String address = input.nextLine();
        logger.info("Enter your Password:");
        String password = input.nextLine();

        User r = new User(username, password, address, phnum, email, gen,0.0);
        boolean create = Operations.addUser(r);
        if (create) {
            logger.info("A new account was created successfully");
            Logging.getQ().put(email, password);
        }
        else
            logger.info("This account already exists");

        homePage();
    }

    public static void viewUserProfile() {
        logger.info("User Profile:");
        logger.info("Username: " + getUsername()); // static methods
        logger.info("Address: " + getAddress());
        logger.info("Phone: " + getPhone());
        logger.info("Email: " + getEmail());
        logger.info("Gender: " + getGender());
    }





    public static void reserveWedding() {
        logger.info("\nReserve Wedding:");

        // Display available venues
        logger.info("Available Venues:");
        List<Venue> availableVenues = Venue.getAvailableVenues();
        for (int i = 0; i < availableVenues.size(); i++) {
            logger.info((i + 1) + ". " + availableVenues.get(i).getName());
        }

        // Prompt user to choose a venue
        logger.info("Choose a venue by entering the corresponding number:");
        int venueChoice = scanner();

        // Validate the venue choice
        if (venueChoice < 1 || venueChoice > availableVenues.size()) {
            logger.info("Invalid choice. Please enter a valid venue number.");
            return;
        }

        // Get the selected venue
        Venue selectedVenue = availableVenues.get(venueChoice - 1);

        // Display available dates for the selected venue
        logger.info("Available Dates for " + selectedVenue.getName() + ":");
        List<Date> availableDates = getAvailableDatesForVenue(venueChoice);
        for (int i = 0; i < availableDates.size(); i++) {
            logger.info((i + 1) + ". " + availableDates.get(i));
        }

        // Prompt user to choose a date
        logger.info("Choose a date by entering the corresponding number:");
        int dateChoice = scanner();

        // Validate the date choice
        if (dateChoice < 1 || dateChoice > availableDates.size()) {
            logger.info("Invalid choice. Please enter a valid date number.");
            return;
        }

        // Get the selected date
        Date selectedDate = availableDates.get(dateChoice - 1);

        // Proceed with the reservation process for the selected date and venue
        // Add your reservation logic here...
    }

    // Helper method to get available dates for the selected venue
    private static List<Date> getAvailableDatesForVenue(int venueChoice) {
        switch (venueChoice) {
            case 1:
                return availableDatesV1;
            case 2:
                return availableDatesV2;

            case 3:
                return availableDatesV3;
            case 4:
                return availableDatesV4;
            case 5:
                return availableDatesV5;



            default:
                return new ArrayList<>(); // Return an empty list if venue choice is invalid
        }
    }



}
