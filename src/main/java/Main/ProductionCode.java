package Main;


import ApplicationClasses.Logging;
import ApplicationClasses.*;
import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.*;

import static ApplicationClasses.AdditionalService.initializeAdditionalService;
import static ApplicationClasses.Admin.getAdminByEmail;
import static ApplicationClasses.Admin.initializeAdmin;
import static ApplicationClasses.Date.initializeAvailableDates;
import static ApplicationClasses.Event.initializeEvents;
import static ApplicationClasses.Operations.*;
import static ApplicationClasses.ServiceProvider.initializeServiceProvider;
import static ApplicationClasses.User.*;
import static ApplicationClasses.Venue.initializeAvailableVenues;


public class ProductionCode {

    public static final String SEPARATOR = "------------------------------------------------------";

    public static final String ENTER_CHOICE= "Enter your choice : ";
    public static Scanner input = new Scanner(System.in);

    protected static Logger logger;

    static {

        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        for (Handler handler : handlers) {
            handler.setFormatter(new SimpleFormatter() {
                @Override
                public String format(LogRecord logRecord) {
                    return logRecord.getMessage() + "\n";
                }
            });
        }
    }





    public static void main(String[] args) {


        logger = Logger.getLogger(Main.class.getName());





        initializeAdmin(); //one admin
        initializeUsers(); // multiple users
        initializeServiceProvider();
        initializeAvailableVenues();
        initializeAvailableDates();
        initializeAdditionalService();
        initializeEvents();
        homePage();

    }


    public static int scanner() {
        int c;

        while (true) {
            try {
                c = input.nextInt();
                break; // Exit the loop if integer input is successfully read
            } catch (java.util.NoSuchElementException e) {
                logger.log(Level.SEVERE, "Invalid input. Please enter a valid integer.", e);
                input.nextLine();
            }
        }
        input.nextLine();// Clear the input buffer
        return c;
    }






    public static void homePage() {

        boolean loggedin=true;
        while (loggedin) {
            logger.info("\nWelcome to the Event Planning System\r\n"
                    + "Do you have an account?\r\n"
                    + "1. Create account\r\n"//only for users
                    + "2. Log-in\r\n"
                    + "3. Exit.\r\n"
                    + ENTER_CHOICE);


            int accountChoice = scanner(); // only integer input


            switch (accountChoice) {
                case 1: {
                    createAccountPage();
                    break;
                }

                case 2: {
                    int utype;
                    int y;

                    Logging u = new Logging();
                    logger.info("Please enter your email : ");
                    String email = input.nextLine();
                    utype = u.searchEmail(email);

                    while (utype < 0) {  // as long as the email does not match with anything

                        logger.info("The email does not exist.Please enter registered email again : ");
                        email = input.nextLine();
                        utype = u.searchEmail(email);
                    }

                    logger.info("Please enter your password : ");
                    String password = input.nextLine();
                    y = u.searchPassword(password);

                    while (y == -33) { // as long as the password does not match with anything

                        logger.info("Invalid password. Please enter your password again : ");
                        password = input.nextLine();
                        y = u.searchPassword(password);

                    }

                    User loggedInUser = null;// Initialize the logged-in user object
                    Admin loggedInAdmin = null;

                    switch (utype) {


                        case 0: {
                            loggedInAdmin = getAdminByEmail(email);
                            SessionManager.loginAdmin(loggedInAdmin);
                            adminActivities();
                            break;

                        }
                        case 1:
                            loggedInUser = getUserByEmail(email);
                            SessionManager.loginUser(loggedInUser);

                            userActivities();
                            break;


                        case 2:

                            serviceProviderActivities();
                            break;
                        default:
                            // Handle unexpected value, log an error, or take appropriate action
                            throw new IllegalArgumentException("Unexpected value for utype: " + utype);

                    }
                    break;
                }

                case 3:loggedin=false;
                    break;

                default:
                    // Handle unexpected value, log an error, or take appropriate action
                    throw new IllegalArgumentException("Unexpected value for accountChoice: " + accountChoice);

            }


        }

        logger.info(SEPARATOR); // Add separator after completing adminManageProducts()

    }




    public static void adminActivities() {

        // Retrieve the logged-in user from the session
        Admin loggedInAdmin = SessionManager.getLoggedInAdmin();
        if (loggedInAdmin == null) {
            logger.info("User not logged in.");
            return;
        }
        logger.info("\nWelcome, Admin: " + loggedInAdmin.getUsername());

        boolean loggedIn = true;
        while (loggedIn) {
            logger.info("Admin Menu:");
            logger.info("1. Manage User Accounts"); // Menu
            logger.info("2. Manage Events"); // Menu
            logger.info("3. View Reservation Requests"); // New option
            logger.info("4. Log Out");
            logger.info(ENTER_CHOICE);

            int choice = scanner(); // Get user input


            switch (choice) {
                case 1:
                    adminManageUsers();
                    break;
                case 2:
                    adminManageProducts();
                    break;
                case 3:
                    viewReservationRequests(); // New case for viewing reservation requests
                    break;
                case 4:
                    loggedIn = false; // Exit the loop and log out
                    break;
                default:
                    logger.info("Invalid choice. Please enter a valid option.");
            }
        }
        logger.info(SEPARATOR); // Add separator after completing adminManageProducts()

    }


    private static void adminManageUsers() {
        boolean continueManaging = true;
        while (continueManaging) {
            logger.info("\nSelect an action for user management:");
            logger.info("1. Change user information");
            logger.info("2. Add new user");
            logger.info("3. See all user accounts");
            logger.info("4. Delete an account");
            logger.info("5. Return to admin menu");
            int action;
            try {
                action = input.nextInt();
            } catch (InputMismatchException e) {
                logger.info("Invalid input. Please enter a valid integer.");
                input.next(); // consume invalid input
                continue; // restart the loop
            }
            switch (action) {
                case 1:
                    changeUserInformation();
                    break;
                case 2:
                    addNewUser();
                    break;
                case 3:
                    seeAllUsers();
                    break;
                case 4:
                    deleteAccount();
                    break;
                case 5:adminActivities();
                    break;
                default:
                    logger.info("Invalid choice. Please enter a valid option.");
            }
        }
        logger.info(SEPARATOR); // Add separator after completing adminManageProducts()

    }

    private static void adminManageProducts() {
        boolean continueManaging = true;
        while (continueManaging) {
            logger.info("Select an action for event management:");
            logger.info("1. Add a new event");
            logger.info("2. List all events");
            logger.info("3. Search for an event by name");
            logger.info("4. Search for an event by price");
            logger.info("5. Delete an event by name");
            logger.info("6. Edit the event information");
            logger.info("7. Return to admin menu");

            int action;
            try {
                action = input.nextInt();
                input.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                logger.info("Invalid input. Please enter a valid integer.");
                input.nextLine(); // Consume invalid input
                continue; // Restart the loop
            }

            switch (action) {
                case 1:
                   addEvent();
                    break;
                case 2:
                   listAllEvents();
                    break;
                case 3:
                    searchEventByName();
                    break;
                case 4:
                   searchEventByPrice();
                    break;
                case 5:
                   deleteEvent();
                    break;
                case 6:
                    editEvent();
                    break;
                case 7:
                    adminActivities();
                    break;
                default:
                    logger.info("Invalid action. Please select a valid action.");
            }
        }
        logger.info(SEPARATOR); // Add separator after completing adminManageProducts()

    }


///////////////////////////////////////////////////////////////////////////////


    public static void userActivities() {
// Retrieve the logged-in user from the session
        User loggedInUser = SessionManager.getLoggedInUser();
        if (loggedInUser == null) {
            logger.info("User not logged in.");
            return;
        }

        logger.info("\nWelcome, User: " + loggedInUser.getUsername());

        boolean loggedIn = true;
        while (loggedIn) {
            logger.info("\nMenu:");
            logger.info("1. My Profile");
            logger.info("2. Reserve a Wedding");
            logger.info("3. Log Out");
            logger.info(ENTER_CHOICE);

            int choice = scanner(); // Get user input

            switch (choice) {
                case 1:
                    viewUserProfile(loggedInUser);
                    break;

                case 2:
                    Operations.reserveWedding();
                    break;
                case 3:
                    loggedIn = false; // Exit the loop and log out
                    break;
                default:
                    logger.info("Invalid choice. Please enter a valid option.");
            }
        }
    }


    public static void serviceProviderActivities(){


        logger.info("Welcome, Service Provider!");

        boolean loggedIn = true;
        while (loggedIn) {
            logger.info("\nService Provider Menu:");
            logger.info("1. Add a new Venue");
            logger.info("2. Add a new additional service for events.");
            logger.info("3. change your personal information");
            logger.info("4. Delete a venue.");
            logger.info("5. Delete an additional service for events.");
            logger.info("6. Log Out");
            logger.info(ENTER_CHOICE);

            int choice = scanner(); // Get user input
            switch (choice) {
                case 1:
                    addNewVenue();
                    break;

                case 2:
                    addService();
                    break;
                case 3:
                    edit_info();
                    break;
                case 6:
                    loggedIn = false; // Exit the loop and log out
                    break;
                default:
                    logger.info("Invalid choice. Please enter a valid option.");
            }


        }


    }}