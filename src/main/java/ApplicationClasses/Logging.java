package ApplicationClasses;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static ApplicationClasses.Admin.adminList;
import static ApplicationClasses.ServiceProvider.ServiceProv_LIST;
import static ApplicationClasses.User.allUsers;

public class Logging {

    private String emailToCheck;
    public boolean isSuccessfulusername() {
        return successfulusername;
    }

    private boolean successfulusername= false;

    public boolean isSuccessfulpassword() {
        return successfulpassword;
    }

    private boolean successfulpassword= false;



    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
    private boolean logState = false;

    public static int getY() {
        return y;
    }

    public static void setY(int y) {
        Logging.y = y;
    }

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





    public boolean isServiceProv(boolean flag) {

        for (int k = 0; k < ServiceProv_LIST.size(); k++) {
            if (email.equals(ServiceProv_LIST.get(k).getEmail())) {
                flag = false;
                successfulusername=true;
                type = 2;
                y=k;
                break;
            }
        }
        return flag;
    }

    public boolean isUser(boolean flag) {
        for (int j = 0; j < User.getUserList().size(); j++) {
            if (email.equals(User.getUserList().get(j).getEmail())) {
                flag = false;
                successfulusername=true;
                type = 1;
                y=j;
                break;
            }
        }
        return flag;
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


}










