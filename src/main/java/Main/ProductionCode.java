package Main;


import ApplicationClasses.Logging;
import ApplicationClasses.Operations;
import ApplicationClasses.User;
import com.sun.tools.javac.Main;

import java.util.Scanner;
import java.util.logging.*;

import static ApplicationClasses.Admin.initializeAdmin;
import static ApplicationClasses.Date.initializeAvailableDates;
import static ApplicationClasses.Operations.viewUserProfile;
import static ApplicationClasses.ServiceProvider.initializeServiceProvider;
import static ApplicationClasses.User.allUsers;
import static ApplicationClasses.User.initializeUsers;
import static ApplicationClasses.Venue.initializeAvailableVenues;
import static ApplicationClasses.AdditionalService.initializeAdditionalService;


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


                    switch (utype) {


                        case 0: {

                            adminActivities();
                            break;

                        }
                        case 1:

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



    public static void adminActivities() {
        logger.info("Welcome, Admin!");

        boolean loggedIn = true;
        while (loggedIn) {
            logger.info("\nAdmin Menu:");
            logger.info("1. View/Edit Wedding Listings");
            logger.info("2. Manage User Accounts");
            logger.info("3. View Reservation Details");
            logger.info("4. Send Notifications");
            logger.info("5. Log Out");
            logger.info(ENTER_CHOICE);

            int choice = scanner(); // Get user input

          /*  switch (choice) {
                case 1:
                    viewEditWeddingListings();
                    break;
                case 2:
                    manageUserAccounts();
                    break;
                case 3:
                    viewReservationDetails();
                    break;
                case 4:
                    sendNotifications();
                    break;
                case 5:
                    loggedIn = false; // Exit the loop and log out
                    break;
                default:
                    logger.info("Invalid choice. Please enter a valid option.");
            }*/
        }
    }


    public static void userActivities() {
        logger.info("Welcome, User!");

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

                    // Retrieve the index of the logged-in user
                    Operations op = new Operations();
                    Logging u = new Logging();
                    logger.info("Please enter your email : ");
                    String email = input.nextLine();
                    op.searchEmailAndUpdateIndex(email);

                    // Check if the user exists
                    if (op.getUserIndex() >= 0) {
                        // Get the user object using the index
                        User loggedInUser = allUsers.get(op.getUserIndex());
                        // Pass the user obje vbghhnmct to viewUserProfile method
                    viewUserProfile(loggedInUser);
                    } else {
                        logger.info("User not found.");
                    }
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





    }


}