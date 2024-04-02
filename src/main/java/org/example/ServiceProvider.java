package org.example;

import ApplicationClasses.ReservationRequest;
import ApplicationClasses.Service;
import ApplicationClasses.Venue;

import java.util.Scanner;
import java.util.logging.*;

public class ServiceProvider {
    int x ;
    private final static Logger logger = Logger.getLogger(ServiceProvider.class.getName());
    public static void main(String[] args){
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


        boolean cont = false;
        Scanner scanner = new Scanner(System.in);

        while (!cont){


            // Log different types of messages
            logger.info("Choose what action you want to do :");
            logger.info("1- Add a new venue.");
            logger.info("2- Add a new additional service for events.");
            logger.info("3- change your personal information");
    //        logger.info("4- Delete a venue.");
    //        logger.info("5- Delete an additional service for events.");


            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    ServiceProvider.addVenue();
                    cont = true;
                    break;
                case "2":
                    ServiceProvider.addService();
                    cont = true;
                    break;
                case "3":
                    ServiceProvider.edit_info();
                    cont = true;
                    break;
                default:
                    logger.info("Please Enter A number.");
            }


       }

    }

    private static void addVenue(){
        String name ="" ;
        String location="" ;
        int capacity =0;

        Scanner scanner = new Scanner(System.in);

        logger.info("Enter Venue Name :");
        name = scanner.nextLine();

        logger.info("Enter Venue Location :");
        location = scanner.nextLine();

        logger.info("Enter Venue Reserving Price : ");

        boolean validInput = false;

        while (!validInput) {
            try {
                logger.info("PLEASE ENTER A NUMBER :");
                capacity = Integer.parseInt(scanner.nextLine());
                validInput = true; // If parsing succeeds, set validInput to true to exit the loop
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        Venue venue = new Venue(name , location , capacity , 1000);
        Venue.addVenueToTheList(venue);
        logger.info("venue added successfully.");

    }
    private static void addService(){
        String name ="" ;
        String provider_name="" ;
        double price =0.0;

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


        Service service = new Service(name, price , provider_name);
        Service.add_service(service);
        logger.info("Service added successfully.");


    }
    private static void edit_info() {
        boolean cont = false;

        while (!cont){

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

}
