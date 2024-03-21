package org.example;

import ApplicationClasses.User;
import ApplicationClasses.event;
import ApplicationClasses.login;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.*;

public class Main {

    private static final Logger logger =  Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        // Remove the default formatter
        logger.setUseParentHandlers(false);
        for (Handler handler : logger.getHandlers()) {
            logger.removeHandler(handler);
        }

        // Add a SimpleFormatter without timestamp
        Handler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter() {
            @Override
            public synchronized String format(LogRecord record) {
                return record.getMessage() + "\n";
            }
        });
        logger.addHandler(handler);

        displayMainMenu();
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        switch (choice) {
            case 1 -> signUpProcedure(input);
            case 2 -> loginProcedure(input);
            default -> logger.info("Invalid option selected.");
        }
    }

    private static void displayMainMenu() {
        logger.info("1: Sign up to make a new account");
        logger.info("2: Login to your account");
    }
    static login o = new login();
    public static void adding(String u,String p,String bd)
    {
        if(u.isEmpty())
            logger.info("please fill your name");
        if(p.isEmpty())
            logger.info("please fill your password");
        o.addUser(new User(u,p,bd));
        logger.info("Your account created successfully");
    }
    private static void signUpProcedure(Scanner input) {
        logger.info("In order to make a new account you have to enter your information");
        String email = getInput(input, "Please enter your Email");
        String password = getInput(input, "Please enter your password");
        String birthDate = getInput(input, "Please enter your BirthDate");
        adding(email, password, birthDate);
    }
    public static int exf(String ku,String p)
    {
        int l=0;
        for (User u: o.getUp())
        {
            if(ku.equals("-")||p.equals("-"))
                l=3;

            else if (ku.equals(u.getUserName()) && u.getPass().equals(p)) {
                l=1;
            }
        }
        return l;
    }
    private static void loginProcedure(Scanner input) {
        String email = getInput(input, "Enter your Gmail account");
        String password = getInput(input, "Enter your password");

        int loginStatus = exf(email, password);
        if (email.equals("-"))
            logger.info("You have to write your name it cant be empty");
        else if (password.equals("-"))
            logger.info("You have to write your password it cant be empty");
        else if (loginStatus == 0) {
            logger.info("there's no account with this information.");
        } else {
            userLoggedIn(input);
        }
    }
    private static String getInput(Scanner input, String prompt) {
        logger.info(prompt);
        return input.next();
    }
    private static void userLoggedIn(Scanner input) {
        logger.info("You have logged in successfully");
       // logger.info("Enter user ID ");
        int choice;
       try{
          choice = input.nextInt();
    } catch (InputMismatchException e) {
        logger.info("Invalid input. Please enter a valid integer.");
        input.next(); // consume invalid input
        return; // exit the method
    }
        switch (choice) {
            case 1 -> handleAdminActions(input);
          //  case 2 -> logger.info("Admins ID :-");
            case 2 -> handleCustomerActions(input);
          //  default -> logger.info("Invalid user ID.");
        }
    }
    private static void handleCustomerActions(Scanner input) {
        boolean continueShopping = true;
        while (continueShopping) {
            logger.info("You are the CUSTOMER. Please select an action:");
            logger.info("1: reserve an event");
            logger.info("2: Change password");
            logger.info("3: View order history");
            logger.info("4: Log out");
            int choice = input.nextInt();
            switch (choice) {
               // case 1 -> customerBuyProduct(input);
               // case 2 -> customerChangePassword(input);
               // case 3 -> customerViewOrderHistory(input);
                case 4 -> {
                    continueShopping = false;
                    logger.info("Logging out as customer.");
                }
                default -> printing();
            }
        }
    }
    private static void handleAdminActions(Scanner input) {
        boolean continueManaging = true;
        while (continueManaging) {
            logger.info("You are the ADMIN. Please select an action:");
            logger.info("1: Manage user accounts");
            logger.info("2: Manage events");
            logger.info("3: Manage Availability Date");
            logger.info("4: Log out");
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> adminManageUsers(input);
                case 2 -> adminManageProducts(input);
                case 3 -> addAvailabilityDate(input);
                case 4 -> {
                    continueManaging = false;
                    logger.info("Admin is logged out.");
                }
                default -> printing();
            }
        }
    }
    private static void addAvailabilityDate(Scanner input) {
        logger.info("Write the date that you want to make it available for reserving:");
        String date = input.next();
        o.addDate(date);
        logger.info("Date added successfully.");
    }
    private static void adminManageProducts(Scanner input) {
        boolean continueManaging=true;
        while (continueManaging) {
            logger.info("Select an action for event management:");
            logger.info("1: Add a new event");
            logger.info("2: List all events");
            logger.info("3: Search for a event by name");
            logger.info("4: Search for a event by price");
            logger.info("5: Return to admin menu");

            int action;
            try {
                action = input.nextInt();
            } catch (InputMismatchException e) {
                logger.info("Invalid input. Please enter a valid integer.");
                input.next(); // consume invalid input
                continue; // restart the loop
            }

            switch (action) {
                case 1 -> addevent(input);
                case 2 -> listAllevents();
                case 3 -> searcheventbyname(input);
                case 4 -> searcheventbyprice(input);
                case 5 -> continueManaging = false;
                default -> printing();
            }
        }
    }
    private static void searcheventbyprice(Scanner input) {
        logger.info("Enter the price of the product to search:");
        int price = input.nextInt();
        serchbyprice(price);
    }
    public static void serchbyprice(int p) {
        int l=0;
        for(event c: o.getev() ){
            if(p==c.getPrice() ){
                String f=String.valueOf(c.getAvailable());
                logger.info(Names);
                logger.info(c.geteventName());
                logger.info(Avalable);
                logger.info(f);
                logger.info(Description+c.getDescrtion());
                l=1;
            }
            if(l==0)
                logger.info("There is No event with this price.");
        }
    }
    private static void searcheventbyname(Scanner input) {
        logger.info("Enter the name of the event for search:");
        String name = input.next();
        o.searchbyname(name);
    }
    public static final  String Description = "Description :- ";
    public static final  String Names = "Name:- ";
    public static final  String Avalable = "The num of available pieces:- ";
    public static void list()
    {
        for(event c:o.getev())
        {
            logger.info(Names+c.geteventName());
            logger.info("Price:- "+c.getPrice());
            logger.info(Avalable+c.getAvailable());
            logger.info(Description+c.getDescrtion());
        }
    }
    private static void listAllevents() {
        list();
    }
    private static void addevent(Scanner input) {
        logger.info("Enter the name of the event:");
        String name = input.next();
        logger.info("Enter the price of the total service:");
        int price = input.nextInt();
        logger.info("Enter the number of available venue:");
        int availability = input.nextInt();
        logger.info("Enter a description for the hall:");
        String description = input.next();

        o.event(name, price, availability, description);
        logger.info("event added successfully.");
    }

    private static void adminManageUsers(Scanner input) {
        boolean continueManaging = true;
        while (continueManaging) {
            logger.info("Select an action for user management:");
            logger.info("1: Change user information");
            logger.info("2: Add new user");
            logger.info("3: See all user accounts");
            logger.info("4: Return to admin menu");
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
                case 3 -> seeAllUsers();
                case 4 -> continueManaging = false;
                default -> printing();
            }
        }
    }
    private static void seeAllUsers() {
        o.seeUser();
    }
    private static void addUser(Scanner input) {
        logger.info("Enter the new username or email:");
        String username = input.next();
        logger.info("Enter the password for the new account:");
        String password = input.next();
        logger.info("Enter the birth date for the new account :");
        String birthDate = input.next();
        adding(username, password, birthDate);
    }
    public static int changeInfo(String g,String np)
    {
        int f=0;
        for(User c:o.getUp())
        {
            if(c.getUserName().equals(g)) {
                c.setPass(np);
                f=1;
            }
        }
        return f;
    }
    private static void printing() {
        logger.info("Invalid choice, please try again.");
    }
    private static void changeUserInformation(Scanner input) {
        logger.info("Enter the username to update:");
        String username = input.next();
        logger.info("Enter the new password for the account:");
        String newPassword = input.next();

        int result = changeInfo(username, newPassword);
        if (result == 0) {
            logger.info("No account founded");
        } else {
            logger.info("Password has changed successfully");
        }
    }


}