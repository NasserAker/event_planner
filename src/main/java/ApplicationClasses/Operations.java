package ApplicationClasses;

import java.util.*;


import static ApplicationClasses.AdditionalService.availableServices;
import static ApplicationClasses.Date.*;
import static ApplicationClasses.ServiceProvider.logger;
import static ApplicationClasses.User.*;
import static Main.ProductionCode.*;



public class Operations {
    public static final String SEPARATOR = "------------------------------------------------------";


    public static boolean createAccountPage()
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

        User r = new User(username, password, address, phnum, email, gen);
        boolean create = addUser(r);
        if (create) {
            logger.info("A new account was created successfully");
            Logging.getQ().put(email, password);
        }
        else
            logger.info("This account already exists");
        logger.info(SEPARATOR);



        homePage();

        return create;
    }



    // Admin Menu
    // Manage User Accounts
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
        logger.info("Enter new user details:");

        logger.info("Email:");
        String email = input.next();

        // Check if the user with the given email already exists
        boolean added = addUserCheck(email);
        if (added) {
            // If the user does not exist, proceed to add the user
            logger.info("Username:");
            String username = input.next();

            logger.info("Password:");
            String password = input.next();

            logger.info("Address:");
            String address = input.next();

            logger.info("Phone:");
            String phone = input.next();

            logger.info("Gender:");
            String gender = input.next();

            // Create a new User object and add it to the list of all users
            User newUser = new User(username, password, address, phone, email, gender);
            User.getUserList().add(newUser);
            logger.info("User added successfully.");
        } else {
            logger.info("Failed to add user. User already exists.");
        }
    }

    public static void seeAllUsers() {
        logger.info("\nAll User Accounts:");

        // Sort the users alphabetically by username
        Collections.sort(allUsers, Comparator.comparing(User::getUsername));

        for (User user : allUsers) {
            StringBuilder userDetails = new StringBuilder();
            userDetails.append("Username: ").append(user.getUsername()).append(", ");
            userDetails.append("Email: ").append(user.getEmail()).append(", ");
            // Append other user details as needed
            logger.info(userDetails.toString());
        }
    }


    public static void deleteAccount() {
        logger.info("All User Accounts:");
        List<User> allUsers = User.getUserList();
        for (int i = 0; i < allUsers.size(); i++) {
            User user = allUsers.get(i);
            logger.info((i + 1) + ". Username: " + user.getUsername() + ", Email: " + user.getEmail());
        }

        logger.info("Enter the number of the user you want to delete, or enter '0' to go back to the menu:");
        int userNumber = input.nextInt();

        // Check if the entered number is '0'
        if (userNumber == 0) {
            logger.info("Returning to the admin menu.");
            return; // Exit the method
        }

        // Check if the entered number is valid
        if (userNumber < 1 || userNumber > allUsers.size()) {
            logger.info("Invalid user number. Please enter a valid number.");
            return; // Exit the method
        }

        // Get the corresponding user based on the entered number
        User userToDelete = allUsers.get(userNumber - 1);

        // Perform deletion
        boolean deleted = deleteUserByEmail(userToDelete.getEmail());
        if (deleted) {
            logger.info("User account deleted successfully.");
        } else {
            logger.info("User not found.");
        }
    }

/////////////////////////



    //Manage Events
    public static void addEvent() {
        try {
            logger.info("Enter the name of the event:");
            String name = input.next();
            logger.info("Enter the price of the total service:");
            int price = input.nextInt();
            logger.info("Enter the number of available venue:");
            int availability = input.nextInt();
            logger.info("Enter a description for the hall:");
            String description = input.next();
            logger.info("Enter a location for the event:");
            String location = input.next();
            logger.info("Enter the time the event will happen at :");
            int time = input.nextInt();
            logger.info("Enter a theme for the event:");
            String theme = input.next();

            // Create a new Event object
            Event newEvent = new Event(name, price, availability, description, location, time, theme);

            // Add the new event to the ArrayList in the Event class
            Event.getAllEvents().add(newEvent);

            logger.info("Event added successfully.");
        } catch (InputMismatchException e) {
            logger.info("Invalid input. Please enter a valid integer.");
            input.nextLine(); // Consume invalid input to prevent infinite loop
            // You can choose to prompt the user to enter the input again or handle it differently
        }
    }


    public static void listAllEvents() {
        ArrayList<Event> allEvents = Event.getAllEvents();

        if (allEvents.isEmpty()) {
            logger.info("No events available.");
        } else {
            logger.info("List of all events:");
            for (Event event : allEvents) {
                String eventDetails = "Event Name: " + event.getEventName() + ", " +
                        "Price: " + event.getPrice() + ", " +
                        "Availability: " + event.getAvailability() + ", " +
                        "Description: " + event.getDescription() + ", " +
                        "Location: " + event.getLocation() + ", " +
                        "Time: " + event.getTime() + ", " +
                        "Theme: " + event.getTheme();
                logger.info(eventDetails);
            }
        }
    }


    public static void searchEventByName() {
        // Prompt the user to enter the name of the event to search for
        logger.info("Enter the name of the event to search for:");
        String searchName = input.next();

        boolean found = false;

        // Iterate over each event and check if it matches the searchName
        for (Event event : Event.getAllEvents()) {
            if (event.getEventName().equalsIgnoreCase(searchName)) {
                logger.info("Event found:");
                logger.info("Event Name: " + event.getEventName());
                logger.info("Price: " + event.getPrice());
                logger.info("Availability: " + event.getAvailability());
                logger.info("Description: " + event.getDescription());
                logger.info("Location: " + event.getLocation());
                logger.info("Time: " + event.getTime());
                logger.info("Theme: " + event.getTheme());
                found = true;
                break; // Stop searching once the event is found
            }
        }

        // If no event with the provided name is found
        if (!found) {
            logger.info("No event with the name '" + searchName + "' found.");
        }
    }

    public static void searchEventByPrice() {
        // Prompt the user to enter the price to search for
        logger.info("Enter the price of the event to search for:");
        int searchPrice = input.nextInt();

        boolean found = false;

        // Iterate over each event and check if it matches the searchPrice
        for (Event event : Event.getAllEvents()) {
            if (event.getPrice() == searchPrice) {
                logger.info("Event found:");
                logger.info("Event Name: " + event.getEventName());
                logger.info("Price: " + event.getPrice());
                logger.info("Availability: " + event.getAvailability());
                logger.info("Description: " + event.getDescription());
                logger.info("Location: " + event.getLocation());
                logger.info("Time: " + event.getTime());
                logger.info("Theme: " + event.getTheme());
                found = true;
            }
        }

        // If no event with the provided price is found
        if (!found) {
            logger.info("No event with the price '" + searchPrice + "' found.");
        }
    }
    public static void deleteEvent() {
        // Display the list of events with their corresponding numbers
        logger.info("List of events:");
        ArrayList<Event> allEvents = Event.getAllEvents();
        for (int i = 0; i < allEvents.size(); i++) {
            logger.info((i + 1) + ". " + allEvents.get(i).getEventName());
        }

        // Prompt the user to enter the number corresponding to the event to delete
        logger.info("Enter the number corresponding to the event you want to delete:");
        int eventNumberToDelete = input.nextInt();

        if (eventNumberToDelete < 1 || eventNumberToDelete > allEvents.size()) {
            logger.info("Invalid event number.");
            return;
        }

        // Delete the event corresponding to the chosen number
        Event eventToDelete = allEvents.get(eventNumberToDelete - 1);
        allEvents.remove(eventToDelete);
        logger.info("Event '" + eventToDelete.getEventName() + "' deleted successfully.");
    }


    public static void editEvent() {
        // Display the list of events with their corresponding numbers
        logger.info("List of events:");
        ArrayList<Event> allEvents = Event.getAllEvents();
        for (int i = 0; i < allEvents.size(); i++) {
            logger.info((i + 1) + ". " + allEvents.get(i).getEventName());
        }

        // Prompt the admin to enter the number corresponding to the event to edit
        logger.info("Enter the number corresponding to the event you want to edit:");
        int eventNumberToEdit = input.nextInt();

        if (eventNumberToEdit < 1 || eventNumberToEdit > allEvents.size()) {
            logger.info("Invalid event number.");
            return;
        }

        // Get the event corresponding to the chosen number
        Event eventToEdit = allEvents.get(eventNumberToEdit - 1);

        // Prompt the admin to enter the new information for the event
        logger.info("Enter the new name of the event:");
        String newName = input.next();
        logger.info("Enter the new price of the event:");
        int newPrice = input.nextInt();
        logger.info("Enter the new number of available venue:");
        int newAvailability = input.nextInt();
        logger.info("Enter the new description for the event:");
        String newDescription = input.next();
        logger.info("Enter the new location for the event:");
        String newLocation = input.next();
        logger.info("Enter the new time the event will happen at:");
        int newTime = input.nextInt();
        logger.info("Enter the new theme for the event:");
        String newTheme = input.next();

        // Update the event with the new information
        eventToEdit.setEventName(newName);
        eventToEdit.setPrice(newPrice);
        eventToEdit.setAvailability(newAvailability);
        eventToEdit.setDescription(newDescription);
        eventToEdit.setLocation(newLocation);
        eventToEdit.setTime(newTime);
        eventToEdit.setTheme(newTheme);

        logger.info("Event edited successfully.");
        // Simply return to the previous menu
    }

    /////////////////////////////////////////


// View Reservation Requests
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



   //////////////////////////////////////////////////////////////////////////////////////















    //User Menu

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





    //Service Provider Menu

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
///////////////////////////////////////////////////////////




    // Randoms
    public static boolean addUserCheck(String email) {
        // Check if a user with the given email already exists
        if (getUserByEmail(email) != null) {
            // User with the same email already exists
            return false;
        }
        // User does not exist
        return true;
    }

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






}