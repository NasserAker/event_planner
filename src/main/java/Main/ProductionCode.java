package Main;


import ApplicationClasses.Logging;
import ApplicationClasses.*;
import com.sun.tools.javac.Main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.*;

import static ApplicationClasses.AdditionalService.initializeAdditionalService;
import static ApplicationClasses.Admin.getAdminByEmail;
import static ApplicationClasses.Admin.initializeAdmin;
import static ApplicationClasses.Date.initializeAvailableDates;
import static ApplicationClasses.Operations.*;
import static ApplicationClasses.ServiceProvider.initializeServiceProvider;
import static ApplicationClasses.SessionManager.loggedInAdmin;
import static ApplicationClasses.User.getUserByEmail;
import static ApplicationClasses.User.initializeUsers;
import static ApplicationClasses.Venue.initializeAvailableVenues;


public class ProductionCode {


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


    }





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

        User r = new User(username, password, address, phnum, email, gen,0.0);
        boolean create = Operations.addUser(r);
        if (create) {
            logger.info("A new account was created successfully");
            Logging.getQ().put(email, password);
        }
        else
            logger.info("This account already exists");

        homePage();

        return create;
    }



    public static void adminActivities() {

        // Retrieve the logged-in user from the session
        Admin loggedInAdmin = SessionManager.getLoggedInAdmin();
        if (loggedInAdmin == null) {
            logger.info("User not logged in.");
            return;
        }
        logger.info("Welcome, Admin: " + loggedInAdmin.getUsername());

        boolean loggedIn = true;
        while (loggedIn) {
            logger.info("\nAdmin Menu:");
            logger.info("1. Manage User Accounts");
            logger.info("2. Manage Events");
            logger.info("3. View Reservation Requests"); // New option
            logger.info("4. Log Out");
            logger.info(ENTER_CHOICE);

            int choice = scanner(); // Get user input

            switch (choice) {
                case 1:
                    adminManageUsers(input);
                    break;
                case 2:
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
    }


    private static void adminManageUsers(Scanner input) {
        boolean continueManaging = true;
        while (continueManaging) {
            logger.info("Select an action for user management:");
            logger.info("1. Change user information");
            logger.info("2. Add new user");
            logger.info("3. See all user accounts");
            logger.info("4. delete an accounts");
            logger.info("5. Return to admin menu");
            int action;
            try{
                action = input.nextInt();}
            catch (InputMismatchException e) {
                logger.info("Invalid input. Please enter a valid integer.");
                input.next(); // consume invalid input
                continue; // restart the loop
            }
            switch (action) {
                case 1 -> changeUserInformation(input);
                case 2 -> addUser(input);
             //   case 3 -> seeAllUsers();
                case 4 -> deleteaccounts();
                case 5 -> continueManaging = false;
                default -> printing();
            }
        }
    }

    private static void changeUserInformation(Scanner input) {
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

    private static void addUser(Scanner input) {
        logger.info("Enter email:");
        String email = input.next();
        logger.info("Enter username:");
        String username = input.next();
        logger.info("Enter password:");
        String password = input.next();
        // Add validation and error handling as needed
        User newUser = new User(username, password, email);
        boolean added = Operations.addUser(newUser);
        if (added) {
            logger.info("User added successfully.");
        } else {
            logger.info("Failed to add user. User already exists.");
        }
    }



    private static void deleteaccounts() {
        logger.info("Enter the email of the user you want to delete:");
        String email = input.next();
        boolean deleted = Operations.deleteUserByEmail(email);
        if (deleted) {
            logger.info("User account deleted successfully.");
        } else {
            logger.info("User not found.");
        }
    }







    private static void printing() {
        logger.info("Invalid action. Please enter a valid option.");
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


///////////////////////////////////////////////////////////////////////////////


    public static void userActivities() {
// Retrieve the logged-in user from the session
        User loggedInUser = SessionManager.getLoggedInUser();
        if (loggedInUser == null) {
            logger.info("User not logged in.");
            return;
        }

        logger.info("Welcome, User: " + loggedInUser.getUsername());

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