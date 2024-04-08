package applicationclasses;

import java.util.HashMap;
import java.util.Map;

import static applicationclasses.Admin.adminList;
import static applicationclasses.User.allUsers;

public class Logging {

    private String emailToCheck;





    private static int y;

    protected static Map<String,String> q= new HashMap<>();




    public int searchEmail(String email) {

        emailToCheck = email;
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

    public int searchPassword(String password) {

        String value = q.get(emailToCheck);

        if (password.equals(value)) {
            return y;
        } else {
            return -33;
        }
    }

    public static Map<String,String> getQ(){
        return q;

    }







}








