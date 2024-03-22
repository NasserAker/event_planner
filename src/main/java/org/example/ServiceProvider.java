package org.example;

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
        logger.info("2- ");
        logger.info("Choose what action you want to do :");

    }
}
