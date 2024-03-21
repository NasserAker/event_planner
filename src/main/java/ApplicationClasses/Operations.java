package ApplicationClasses;

import static ApplicationClasses.ServiceProvider.logger;
import static Main.ProductionCode.homePage;
import static Main.ProductionCode.input;
import static ApplicationClasses.User.*;

public class Operations {


    public static boolean addUser(User c) {
        boolean add=true;
        for(int i = 0; i< User.getUserList().size() ; i++) {
            if((User.getUserList().get(i).getEmail().equals(c.getEmail()))||((User.getUserList().get(i).getEmail().equals(c.getEmail())) && (User.getUserList().get(i).getUsername().equals(c.getUsername())) && (User.getUserList().get(i).getAddress().equals(c.getAddress()))&& (User.getUserList().get(i).getPhone().equals(c.getPhone()))))
            {
                add = false;
                break;
            }
        }
        if(add) {
            User.getUserList().add(c);
        }
        return add;
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

    public static void viewUserProfile() {
        logger.info("User Profile:");
        logger.info("Username: " + getUsername()); // static methods
        logger.info("Address: " + getAddress());
        logger.info("Phone: " + getPhone());
        logger.info("Email: " + getEmail());
        logger.info("Gender: " + getGender());
    }


    public static void reserveWedding(){






    }


}
