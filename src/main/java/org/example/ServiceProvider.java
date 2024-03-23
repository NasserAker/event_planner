package org.example;

import ApplicationClasses.ReservationRequest;
import ApplicationClasses.Service;
import ApplicationClasses.Venue;

import java.util.Scanner;
import java.util.logging.*;

public class ServiceProvider {
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


        // Log different types of messages
        logger.info("Choose what action you want to do :");
        logger.info("1- Add a new venue.");
        logger.info("2- Add a new additional service for events.");
        logger.info("3- See requests to reserve a venue.");
        logger.info("4- change your personal information");



    }

    private void addVenue(){
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


        Venue venue = new Venue(name , location , capacity);
        Venue.addVenueToTheList(venue);
        logger.info("venue added successfully.");

    }

    private void addService(){
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

    private void approveRequests(){
        logger.info("You Have the following Requests :");
        for(ReservationRequest request : ReservationRequest.RequestList){
            logger.info("1- ID :" + request.GetRequestId() + " customer name : ");
        }

    }


}
