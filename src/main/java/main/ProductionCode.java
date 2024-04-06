package main;


import applicationclasses.Logging;
import applicationclasses.*;
import com.sun.tools.javac.Main;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.*;

import static applicationclasses.AdditionalService.initializeAdditionalService;
import static applicationclasses.Admin.getAdminByEmail;
import static applicationclasses.Admin.initializeAdmin;
import static applicationclasses.Date.initializeAvailableDates;
import static applicationclasses.Event.initializeEvents;
import static applicationclasses.Operations.viewReservationRequests;
import static applicationclasses.ServiceProvider.getServiceByEmail;
import static applicationclasses.ServiceProvider.initializeServiceProvider;
import static applicationclasses.User.*;
import static applicationclasses.Venue.initializeAvailableVenues;


public class ProductionCode {

    public static final String SEPARATOR = "------------------------------------------------------";

    public static final String ENTER_CHOICE= "Enter your choice : ";
    public static final Scanner input = new Scanner(System.in);

    protected static Logger logger;
    private static final String INVALID_INTEGER_MESSAGE = "Invalid input. Please enter a valid integer.";
    private static final String INVALIDMESSAGE = "Invalid choice. Please enter a valid option.";


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





        initializeAdmin();
        initializeUsers();
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
                break;
            } catch (java.util.NoSuchElementException e) {
                logger.log(Level.SEVERE, INVALID_INTEGER_MESSAGE, e);
                input.nextLine();
            }
        }
        input.nextLine();
        return c;
    }






    public static void homePage() {

        boolean loggedin=true;
        while (loggedin) {
            logger.info("\nWelcome to the Event Planning System\r\n"
                    + "Do you have an account?\r\n"
                    + "1. Create account\r\n"
                    + "2. Log-in\r\n"
                    + "3. Exit.\r\n"
                    + ENTER_CHOICE);


            int accountChoice = scanner();


            switch (accountChoice) {
                case 1: {
                    Operations.createAccountPage();
                    break;
                }

                case 2: {
                    int utype;
                    int y;

                    Logging u = new Logging();
                    logger.info("Please enter your email : ");
                    String email = input.nextLine();
                    utype = u.searchEmail(email);

                    while (utype < 0) {

                        logger.info("The email does not exist.Please enter registered email again : ");
                        email = input.nextLine();
                        utype = u.searchEmail(email);
                    }

                    logger.info("Please enter your password : ");
                    String password = input.nextLine();
                    y = u.searchPassword(password);

                    while (y == -33) {

                        logger.info("Invalid password. Please enter your password again : ");
                        password = input.nextLine();
                        y = u.searchPassword(password);

                    }

                    User loggedInUser = null;
                    Admin loggedInAdmin = null;
                    ServiceProvider loggedInServiceProvider = null;
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
                            loggedInServiceProvider = getServiceByEmail(email);
                            SessionManager.loginServiceProvider(loggedInServiceProvider);
                            serviceProviderActivities();
                            break;
                        default:

                            throw new IllegalArgumentException("Unexpected value for utype: " + utype);

                    }
                    break;
                }

                case 3:loggedin=false;
                    break;

                default:

                    throw new IllegalArgumentException("Unexpected value for accountChoice: " + accountChoice);

            }


        }

        logger.info(SEPARATOR);

    }




    public static void adminActivities() {


        Admin loggedInAdmin = SessionManager.getLoggedInAdmin();
        if (loggedInAdmin == null) {
            logger.info("User not logged in.");
            return;
        }
        logger.info("\nWelcome, Admin: " + loggedInAdmin.getUsername());

        boolean loggedIn = true;
        while (loggedIn) {
            logger.info("Admin Menu:");
            logger.info("1. Manage User Accounts");
            logger.info("2. Manage Events");
            logger.info("3. View Reservation Requests");
            logger.info("4. Log Out");
            logger.info(ENTER_CHOICE);

            int choice = scanner();


            switch (choice) {
                case 1:
                    adminManageUsers();
                    break;
                case 2:
                    adminManageProducts();
                    break;
                case 3:
                    viewReservationRequests();
                    break;
                case 4:
                    loggedIn = false;
                    break;
                default:
                    logger.info(INVALIDMESSAGE);
            }
        }
        logger.info(SEPARATOR);

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
                logger.info(INVALID_INTEGER_MESSAGE);
                input.next();
                continue;
            }
            switch (action) {
                case 1:
                    Operations.changeUserInformation();
                    break;
                case 2:
                    Operations.addNewUser();
                    break;
                case 3:
                    Operations.seeAllUsers();
                    break;
                case 4:
                    Operations.deleteAccount();
                    break;
                case 5:adminActivities();
                    continueManaging = false;
                    break;
                default:
                    logger.info(INVALIDMESSAGE);
            }
        }
        logger.info(SEPARATOR);

    }

    private static void adminManageProducts() {
        boolean continueManaging = true;
        while (continueManaging) {
            logger.info("\nSelect an action for event management:");
            logger.info("1. Add a new event");
            logger.info("2. List all events");
            logger.info("3. Search for an event by name");
            logger.info("4. Search for an event by price");
            logger.info("5. Delete an event");
            logger.info("6. Edit the event information");
            logger.info("7. Return to admin menu");

            int action;
            try {
                action = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                logger.info(INVALID_INTEGER_MESSAGE);
                input.nextLine();
                continue;
            }

            switch (action) {
                case 1:
                   Operations.addEvent();
                    break;
                case 2:
                   Operations.listAllEvents();
                    break;
                case 3:
                    Operations.searchEventByName();
                    break;
                case 4:
                   Operations.searchEventByPrice();
                    break;
                case 5:
                   Operations.deleteEvent();
                    break;
                case 6:
                    Operations.editEvent();
                    break;
                case 7:
                    adminActivities();
                    continueManaging = false;
                    break;
                default:
                    logger.info("Invalid action. Please select a valid action.");
            }
        }
        logger.info(SEPARATOR);

    }





    public static void userActivities() {

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

            int choice = scanner();

            switch (choice) {
                case 1:
                    Operations.viewUserProfile(loggedInUser);
                    break;

                case 2:
                    Operations.reserveWedding(loggedInUser);
                    break;
                case 3:
                    loggedIn = false;
                    break;
                default:
                    logger.info(INVALIDMESSAGE);
            }
        }
        logger.info(SEPARATOR);

    }


    public static void serviceProviderActivities(){


        ServiceProvider loggedInServiceProvider = SessionManager.getLoggedInServiceProvider();
        if (loggedInServiceProvider == null) {
            logger.info("Service provider not logged in.");
            return;
        }
        logger.info("\nWelcome, Service Provider: " + loggedInServiceProvider.getName());
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

            int choice = scanner();
            switch (choice) {
                case 1:
                    Operations.addNewVenue();
                    break;

                case 2:
                    Operations.addService();
                    break;
                case 3:
                    Operations.editinfo();
                    break;
                case 6:
                    loggedIn = false;
                    break;
                default:
                    logger.info(INVALIDMESSAGE);
            }


        }
        logger.info(SEPARATOR);


    }}