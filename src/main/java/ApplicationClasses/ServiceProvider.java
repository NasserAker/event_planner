package ApplicationClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ServiceProvider {


    private String name;
    private String email;
    private String address;
    private String phone;

    public String getIdd() {
        return idd;
    }

    private String idd;
    boolean available;
    @SuppressWarnings("unused")

    boolean logState;
    String pass;


    protected static final List<ServiceProvider> ServiceProv_LIST = new ArrayList<>() ;
    private final Map<User,String> reservaedDates= new HashMap<>();


    static final Logger logger = Logger.getLogger(ServiceProvider.class.getName());



    static {

        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        for (Handler handler : handlers) {
            handler.setFormatter(new SimpleFormatter() {
                @Override
                public String format(LogRecord logRecord) {
                    return logRecord.getMessage() + "\n";
                }
            });
        }
    }


    public ServiceProvider() {
        logState=false;
        pass="worker123";

    }



    public ServiceProvider(String email, String name, String password, String address, String phone, String iD, boolean available) {
        super();
        this.pass = password;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.idd = iD;
        this.available = available;

        this.email=email;

    }






    public static List<ServiceProvider> getServiceProvList() {return ServiceProv_LIST;}

    public Map<User,String> getReservaeddates() {return reservaedDates;}

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }
    public void logging(boolean t) {logState=t;}
    public boolean getLogState() {return logState;}
    public String getName() {
        return name;
    }
    public void setName(String name) {this.name = name;}
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }


}
