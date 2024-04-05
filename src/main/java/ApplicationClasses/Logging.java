package ApplicationClasses;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static ApplicationClasses.Admin.adminList;
import static ApplicationClasses.User.allUsers;

public class Logging {

    private String emailToCheck;




    private boolean successfulpassword= false;

    private String email;

    public void setEmail(String email) {
        this.email = email;
    }




    private String password;
    private boolean logState = false;




    private static int y;
    int type = -3;

    protected static Map<String,String> q= new HashMap<>();//how to make it protected
    final Logger logger = Logger.getLogger(Logging.class.getName());


    public int searchEmail(String email) {
        // Search through the admin list
        emailToCheck = email;
        for (Admin admin : adminList) {
            if (email.equals(admin.getEmail())) {
                return 0; // Admin found
            }
        }

        // Search through the user list
        for (User user : allUsers) {
            if (email.equals(user.getEmail())) {
                return 1; // User found
            }
        }

        // Search through the service provider list
        for (ServiceProvider serviceProvider : ServiceProvider.getServiceProviderList()) {
            if (email.equals(serviceProvider.getEmail())) {
                return 2; // Service provider found
            }
        }

        // If the email is not found in any list, return -1
        return -1;
    }









    public int searchPassword(String password) {
        // Retrieve the stored password associated with the email being searched
        String value = q.get(emailToCheck);
        // Compare the provided password with the stored password
        if (password.equals(value)) {
            successfulpassword = true;
            logState = true;
            return y;
        } else {
            successfulpassword = false;
            return -33;
        }
    }






    public static Map<String,String> getQ(){
        return q;

    }
    public void logState(boolean t) {

        logState=t;
    }

    public boolean login(String password) {

        if(this.password.equals(password)) {
            logger.info("successfully logged in");
            logState=true;
            return true;

        }
        else {
            logger.info("wrong password");
            return false;
        }
    }

    public void setLogState(boolean t) {

        logState=t;
    }
    public boolean getLogState() {
        return logState;
    }
    public void logout() {

        logState = false;
    }

    public int searchUser(String email, String password) {
        // Search for the user based on email
        int userType = searchEmail(email);

        if (userType >= 0) {
            // User found, now check if the password is correct
            int passwordCheck = searchPassword(password);
            if (passwordCheck == -33) {
                // Password is correct, return the user type
                return userType;
            }
        }

        // Return -1 if user is not found or password is incorrect
        return -1;
    }
}










