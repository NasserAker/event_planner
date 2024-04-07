package applicationclasses;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static applicationclasses.Admin.adminList;
import static applicationclasses.User.allUsers;

public class Logging {

    private String password;
    private boolean logState = false;

    private static int y;
    int type = -3;

    protected static Map<String,String> q= new HashMap<>();
    final Logger logger = Logger.getLogger(Logging.class.getName());


    public int searchEmail(String email) {
        String emailToCheck = email;

        for (Admin admin : adminList) {
            if (email.equals(admin.getEmail())) {
                return 0;
            }
        }

        for (User user : allUsers) {
            if (email.equals(user.getEmail())) {
                return 1;
            }
        }

        for (ServiceProvider serviceProvider : ServiceProvider.getServiceProviderList()) {
            if (email.equals(serviceProvider.getEmail())) {
                return 2;
            }
        }

        return -1;
    }

    public int searchPassword(String email, String password) {
        String value = q.get(email);

        boolean successfulpassword = password.equals(value);

        if (successfulpassword) {
            logState = true;
            return y;
        } else {
            return -33;
        }
    }

    public static Map<String,String> getQ(){
        return q;
    }

    public void logState(boolean t) {
        logState=t;
    }

    public boolean login(String email, String password) {
        if(this.password.equals(password)) {
            logger.info("successfully logged in");
            logState=true;
            return true;
        } else {
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
        int userType = searchEmail(email);

        if (userType >= 0) {
            int passwordCheck = searchPassword(email, password);
            if (passwordCheck == -33) {
                return userType;
            }
        }
        return -1;
    }
}
