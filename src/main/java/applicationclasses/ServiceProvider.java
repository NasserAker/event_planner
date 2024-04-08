package applicationclasses;

import java.util.*;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ServiceProvider {


    private String name;
    private String email;
    private String address;
    private String phone;

    public static List<ServiceProvider> getServiceProviderList() {
        return ServiceProv_LIST;
    }



    private String idd;
    boolean available;
    @SuppressWarnings("unused")

    boolean logState;
    String pass;


    public static final List<ServiceProvider> ServiceProv_LIST = new ArrayList<>();


    public static final Logger logger = Logger.getLogger(ServiceProvider.class.getName());

    public static void initializeServiceProvider() {
        ServiceProvider s1 = new ServiceProvider("nada@gmail.com", "woroud", "123123", "RAM", "0599852446", "122", true);
        ServiceProv_LIST.add(s1);
        Logging.getQ().put(s1.getEmail(), s1.getPass());

        ServiceProvider s2 = new ServiceProvider("ahmad@gmail.com", "ahmad", "123", "nablus", "0595789441", "123", true);
        ServiceProv_LIST.add(s2);
        Logging.getQ().put(s2.getEmail(), s2.getPass());

        ServiceProvider s3 = new ServiceProvider("leen@gmail.com", "leen", "123", "SAM", "0595123556", "124", false);
        ServiceProv_LIST.add(s3);
        Logging.getQ().put(s3.getEmail(), s3.getPass());
    }


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


    public ServiceProvider(String email, String name, String password, String address, String phone, String iD, boolean available) {
        super();
        this.pass = password;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.idd = iD;
        this.available = available;

        this.email = email;

    }


    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ServiceProvider getServiceByEmail(String email) {
        for (ServiceProvider serviceProvider : ServiceProv_LIST) {
            if (serviceProvider.getEmail().equals(email)) {
                return serviceProvider;
            }
        }
        return null;
    }


}