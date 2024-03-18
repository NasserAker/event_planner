package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        displayMainMenu();
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        switch (choice) {
            case 1 -> signUpProcedure(input);
            case 2 -> loginProcedure(input);
            default -> logger.info("Invalid option selected.");
        }
    }
    private static final Logger logger =  Logger.getLogger(Main.class.getName());
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

    }


}