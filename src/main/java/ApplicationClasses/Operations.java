package ApplicationClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ApplicationClasses.AdditionalService.availableServices;
import static ApplicationClasses.Date.*;
import static ApplicationClasses.ServiceProvider.logger;
import static ApplicationClasses.User.allUsers;
import static Main.ProductionCode.*;



public class Operations {


    public static boolean addUser(User c) {
        for (User user : allUsers) {
            // Check if email or all other attributes match with any existing user
            if (c.getEmail().equals(user.getEmail()) ||
                    (c.getUsername().equals(user.getUsername()) &&
                            c.getAddress().equals(user.getAddress()) &&
                            c.getPhone().equals(user.getPhone()))) {
                return false; // User already exists
            }
        }
        allUsers.add(c); // If no match found, add the user
        return true; // User added successfully
    }


    public static void createAccountPage() {

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

        User r = new User(username, password, address, phnum, email, gen, 0.0);
        boolean create = Operations.addUser(r);
        if (create) {
            logger.info("A new account was created successfully");
            Logging.getQ().put(email, password);
        } else
            logger.info("This account already exists");

        homePage();
    }

    public static void viewUserProfile(User user) {
        logger.info("User Profile:");
        logger.info("Username: " + user.getUsername());
        logger.info("Address: " + user.getAddress());
        logger.info("Phone: " + user.getPhone());
        logger.info("Email: " + user.getEmail());
        logger.info("Gender: " + user.getGender());
    }


    private int userIndex = -1; // Initialize to -1 to indicate user not found

    public void searchEmailAndUpdateIndex(String email) {
        for (int i = 0; i < allUsers.size(); i++) {
            if (email.equals(allUsers.get(i).getEmail())) {
                userIndex = i; // Update the index variable
                return; // Exit the loop once the user is found
            }
        }
        // If the email is not found in any list, set the index to -1
        userIndex = -1;
    }

    public int getUserIndex() {
        return userIndex;
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


        logger.info("Available Additional Services:");
        AdditionalService.initializeAdditionalService();
        for (int i = 0; i < availableServices.size(); i++) {
            AdditionalService service = availableServices.get(i);
            logger.info((i + 1) + ". " + service.getServiceName() + " - Cost: $" + service.getCost());
        }
        logger.info("0. None");

        // Prompt user to choose additional service
        logger.info("Choose an additional service by entering the corresponding number:");
        int additionalServiceChoice = scanner();

        // Validate the additional service choice
        if (additionalServiceChoice < 0 || additionalServiceChoice > availableServices.size()) {
            logger.info("Invalid choice. Please enter a valid number.");
            return;
        }

        // Process the selected additional service
        AdditionalService selectedService = null;
        if (additionalServiceChoice != 0) {
            selectedService = availableServices.get(additionalServiceChoice - 1);
        }
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

    public static void addNewVenue() {
        String name = "";
        String location = "";
        int capacity = 0;
        double cost = 0.0;

        Scanner scanner = new Scanner(System.in);

        logger.info("Enter Venue Name:");
        name = scanner.nextLine();

        logger.info("Enter Venue Location:");
        location = scanner.nextLine();

        logger.info("Enter Venue Capacity:");

        boolean validCapacityInput = false;

        while (!validCapacityInput) {
            try {
                logger.info("PLEASE ENTER A NUMBER:");
                capacity = Integer.parseInt(scanner.nextLine());
                validCapacityInput = true; // If parsing succeeds, set validCapacityInput to true to exit the loop
            } catch (NumberFormatException e) {
                logger.info("Invalid input. Please enter a valid number for capacity.");
            }
        }

        logger.info("Enter Venue Reserving Price:");

        boolean validCostInput = false;

        while (!validCostInput) {
            try {
                logger.info("PLEASE ENTER A NUMBER:");
                cost = Double.parseDouble(scanner.nextLine());
                validCostInput = true; // If parsing succeeds, set validCostInput to true to exit the loop
            } catch (NumberFormatException e) {
                logger.info("Invalid input. Please enter a valid number for cost.");
            }
        }

        Venue venue = new Venue(name, location, capacity, cost);
        Venue.addVenueToTheList(venue);
        logger.info("Venue added successfully.");
    }
















}