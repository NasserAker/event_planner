package applicationclasses;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Logging {


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


    public int searchEmail(String email1){

        boolean flag = true;

        email = email1;

        for (int i = 0; i < Admin.getAdminList().size(); i++) {
            if (email.equals(Admin.getAdminList().get(i).getEmail())) {
                flag = false;
                successfulusername=true;
                type = 0;
                y=i;
                break;
            }}

        if (flag) {
            flag = isUser(flag);
        }

        if (flag) {
            isServiceProv(flag);
        }


        return type;

    }

    public boolean isServiceProv(boolean flag) {

        for (int k = 0; k < ServiceProvider.getServiceProvList().size(); k++) {
            if (email.equals(ServiceProvider.getServiceProvList().get(k).getEmail())) {
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


    public int searchPassword(String password2){

        password = password2;

        String passw = password;
        String value = q.get(email);

        if (passw.equals(value)) {
            successfulpassword = true;

            logState = true;
            return y;
        }
        else {
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










