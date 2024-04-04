package ApplicationClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



import static ApplicationClasses.AdditionalService.availableServices;
import static ApplicationClasses.Date.*;
import static ApplicationClasses.ServiceProvider.logger;
import static ApplicationClasses.User.allUsers;
import static ApplicationClasses.User.getUserByEmail;
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
    public static boolean deleteUserByEmail(String email) {
        User userToDelete = getUserByEmail(email);
        if (userToDelete != null) {
            // Remove the user from the allUsers list
            User.getUserList().remove(userToDelete);
            // Optionally, you might want to update other related data structures or perform additional cleanup
            return true; // User successfully deleted
        } else {
            return false; // User not found
        }
    }
    public static void deleteAccount() {
        logger.info("Enter the email of the user you want to delete:");
        String email = input.next();
        boolean deleted = Operations.deleteUserByEmail(email);
        if (deleted) {
            logger.info("User account deleted successfully.");
        } else {
            logger.info("User not found.");
        }
    }



    public static void viewReservationRequests() {
        // Logic to display reservation requests to the admin
        List<ReservationRequest> requests = ReservationManager.getAllReservationRequests();
        if (requests.isEmpty()) {
            logger.info("There are no pending reservation requests.");
        } else {
            logger.info("Pending Reservation Requests:");
            for (int i = 0; i < requests.size(); i++) {
                logger.info((i + 1) + ". " + requests.get(i).toString());
            }
        }
    }

    public static void viewUserProfile(User user) {
        logger.info("User Profile:");
        logger.info("Username: " + user.getUsername());
        logger.info("Address: " + user.getAddress());
        logger.info("Phone: " + user.getPhone());
        logger.info("Email: " + user.getEmail());
        logger.info("Gender: " + user.getGender());
    }




    public static void reserveWedding() {
        logger.info("\nReserve Wedding:");

        // Display available venues
        logger.info("Available Venues:");
        List<Venue> availableVenues = Venue.getAvailableVenues();
        for (int i = 0; i < availableVenues.size(); i++) {
            logger.info((i + 1) + ". " + availableVenues.get(i).toString());
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
        logger.info("Choose a date by entering the corresponding number, or enter 0 to go back to choosing a venue:");
        int dateChoice = scanner();

        // Validate the date choice
        if (dateChoice == 0) {
            // Go back to choosing a venue
            reserveWedding(); // Recursive call to reserveWedding() to start the process again
            return; // Exit the current invocation of reserveWedding() to avoid executing further code
        } else if (dateChoice < 1 || dateChoice > availableDates.size()) {
            logger.info("Invalid choice. Please enter a valid date number.");
            return;
        }

// Get the selected date
        Date selectedDate = availableDates.get(dateChoice - 1);


        logger.info("Available Additional Services:");
        AdditionalService.initializeAdditionalService();
        for (int i = 0; i < availableServices.size(); i++) {
            AdditionalService service = availableServices.get(i);
            logger.info((i + 1) + ". " + service.getServiceName() + " - Cost: $" + service.getCost());
        }
        logger.info("0. None");

        // Prompt user to choose additional services
        logger.info("Choose additional services (enter numbers separated by commas, or 0 for none):");
        String additionalServiceChoicesStr = input.nextLine();
        String[] additionalServiceChoices = additionalServiceChoicesStr.split(",");

        // Process selected additional services
        List<AdditionalService> selectedServices = new ArrayList<>();
        for (String choice : additionalServiceChoices) {
            int serviceChoice = Integer.parseInt(choice.trim());
            if (serviceChoice > 0 && serviceChoice <= availableServices.size()) {
                selectedServices.add(availableServices.get(serviceChoice - 1));
            }


        }
        logger.info("Reservation Details:");
        logger.info("Venue: " + selectedVenue.toString());
        logger.info("Date: " + selectedDate);
        if (!selectedServices.isEmpty()) {
            logger.info("Additional Services:");
            for (AdditionalService service : selectedServices) {
                logger.info("- " + service.getServiceName() + " - Cost: $" + service.getCost());
            }
        } else {
            logger.info("Additional Services: None");
        }
        // Prompt user to submit or go back to the main menu
        logger.info("1. Submit Reservation");
        logger.info("2. Go back to Menu");
        logger.info("Enter your choice:");
        int choice = scanner();
        switch (choice) {
            case 1:
                // Submit reservation
                submitReservation(selectedVenue, selectedDate, selectedServices);
                break;
            case 2:
                userActivities();
                break;
            default:
                logger.info("Invalid choice. Returning to the main menu.");
                break;
        }


    }


    public static void submitReservation(Venue venue, Date date, List<AdditionalService> services) {
        // Implement logic to save the reservation to the database or perform other actions
        // You can also display a success message here
        logger.info("Reservation submitted successfully!");
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



    public static void addService() {
        String name = "";
        String provider_name = "";
        double price = 0.0;

        Scanner scanner = new Scanner(System.in);

        logger.info("Enter Service Name :");
        name = scanner.nextLine();

        logger.info("Enter your name :");
        provider_name = scanner.nextLine();

        logger.info("Enter Service Price : ");

        boolean validInput = false;

        while (!validInput) {
            try {
                logger.info("PLEASE ENTER A NUMBER :");
                price = Integer.parseInt(scanner.nextLine());
                validInput = true; // If parsing succeeds, set validInput to true to exit the loop
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }


        AdditionalService service = new AdditionalService(name, price);
        AdditionalService.add_servicetoTheArray(service);
        logger.info("Service added successfully.");


    }


    public static void edit_info() {
        boolean cont = false;

        while (!cont) {

            logger.info("choose what you want to edit :");
            logger.info("1- Name");
            logger.info("2- E-Mail");
            logger.info("3- Address");
            logger.info("4- Phone");

            Scanner scanner = new Scanner(System.in);

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    cont = true;
                    break;
                case "2":
                    cont = true;
                    break;
                case "3":
                    cont = true;
                    break;
                case "4":
                    cont = true;
                    break;
                default:
                    logger.info("Please Enter A number.");
            }


        }


    }


    public static void seeAllUsers() {
        logger.info("All User Accounts:");
        for (User user : allUsers) {
            logger.info("Username: " + user.getUsername());
            logger.info("Email: " + user.getEmail());
            // Print other user details as needed
        }
    }
    public static boolean addUserCheck(String email) {
        // Check if a user with the given email already exists
        if (getUserByEmail(email) != null) {
            // User with the same email already exists
            return false;
        }
        // User does not exist
        return true;
    }


    public static void changeUserInformation() {
        logger.info("Enter the email of the user you want to update:");
        String email = input.next();
        User user = getUserByEmail(email);
        if (user != null) {
            logger.info("User found. Enter new information:");
            // Prompt user to enter new information and update the user object
            // For example:
            logger.info("Enter new username:");
            String newUsername = input.next();
            user.setUsername(newUsername);
            logger.info("Enter new password:");
            String newPassword = input.next();
            user.setPassword(newPassword);
            // Update other user information as needed
            logger.info("User information updated successfully.");
        } else {
            logger.info("User not found.");
        }
    }

    public static void addNewUser() {
        System.out.println("Enter new user details:");

        System.out.println("Email:");
        String email = input.next();

        // Check if the user with the given email already exists
        boolean added = addUserCheck(email);
        if (added) {
            // If the user does not exist, proceed to add the user
            System.out.println("Username:");
            String username = input.next();

            System.out.println("Password:");
            String password = input.next();

            System.out.println("Address:");
            String address = input.next();

            System.out.println("Phone:");
            String phone = input.next();

            System.out.println("Gender:");
            String gender = input.next();

            // Create a new User object and add it to the list of all users
            User newUser = new User(username, password, address, phone, email, gender);
            User.getUserList().add(newUser);
            System.out.println("User added successfully.");
        } else {
            System.out.println("Failed to add user. User already exists.");
        }
    }



}