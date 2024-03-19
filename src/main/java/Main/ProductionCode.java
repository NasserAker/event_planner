package Main;



import java.util.Scanner;
import java.util.logging.*;

import com.sun.tools.javac.Main;
import ApplicationClasses.*;



public class ProductionCode {


    public static final String ENTER_CHOICE= "Enter your choice : ";
    protected static Scanner input = new Scanner(System.in);

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


        Admin a = new Admin("rayabreak02@gmail.com", "raya", "12345");
        Admin.getAdminList().add(a);
        Logging.getQ().put(a.getEmail(), a.getPassword());

        User r1 = new User("sara", "111", "QAM", "02872228", "sara@gmail.com", "Female", 0.0);
        User r2 = new User("dana", "222", "DAM", "02872532", "danabutterfly4@gmail.com", "Female", 0.0);

        User.getUserList().add(r1);
        User.getUserList().add(r2);

        Logging.getQ().put(r1.getEmail(), r1.getPassword());
        Logging.getQ().put(r2.getEmail(), r2.getPassword());





        ServiceProvider s1 = new ServiceProvider("nada@gmail.com", "woroud", "123123", "RAM", "0599852446", "122", true);
        ServiceProvider s2 = new ServiceProvider("ahmad@gmail.com", "ahmad", "123", "nablus", "0595789441", "123", true);
        ServiceProvider s3 = new ServiceProvider("leen@gmail.com", "leen", "123", "SAM", "0595123556", "124", false);

        ServiceProvider.getServiceProvList().add(s1);
        ServiceProvider.getServiceProvList().add(s2);
        ServiceProvider.getServiceProvList().add(s3);


        s1.getReservaeddates().put(r2, "24/10/2024");//service provider is reserved at 24/10/2024

        Logging.getQ().put(s1.getEmail(), s1.getPass());
        Logging.getQ().put(s3.getEmail(), s3.getPass());
        Logging.getQ().put(s2.getEmail(), s3.getPass());


        //all users including service providers and admins must be added to the arraylist q



        homePage();

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

                    Logging user = new Logging();
                    logger.info("Please enter your email : ");
                    String email = input.nextLine();
                    utype = user.searchEmail(email);

                    while (utype < 0) {

                        logger.info("Please enter your email again : ");
                        email = input.nextLine();
                        utype = user.searchEmail(email);
                    }

                    logger.info("Please enter your password : ");
                    String password = input.nextLine();
                    y = user.searchPassword(password);

                    while (y == -33) {

                        logger.info("Please enter your password again : ");
                        password = input.nextLine();
                        y = user.searchPassword(password);

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

            switch (choice) {
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
            }
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
                    viewUserProfile();
                    break;
                case 2:
                    reserveWedding();
                    break;
                case 3:
                    loggedIn = false; // Exit the loop and log out
                    break;
                default:
                    logger.info("Invalid choice. Please enter a valid option.");
            }
        }
    }



}
