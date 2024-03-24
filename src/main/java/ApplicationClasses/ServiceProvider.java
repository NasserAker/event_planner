package ApplicationClasses;

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

    public String getIdd() {
        return idd;
    }

    private String idd;
    boolean available;
    @SuppressWarnings("unused")

    boolean logState;
    String pass;


    protected static final List<ServiceProvider> ServiceProv_LIST = new ArrayList<>();
    private final Map<User, String> reservaedDates = new HashMap<>();


    static final Logger logger = Logger.getLogger(ServiceProvider.class.getName());

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

    public void logging(boolean t) {
        logState = t;
    }

    public boolean getLogState() {
        return logState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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




    private static void edit_info() {
        boolean cont = false;

        while (!cont) {

            logger.info("choose what you want to edit :");
            logger.info("1- Name");
            logger.info("2- E-Mail");
            logger.info("3- Address");
            logger.info("4- Phone");

            Scanner scanner = new Scanner(System.in);

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    cont = true;
                    break;
                case "2":
                    cont = true;
                    break;
                case "3":
                    cont = true;
                    break;
                case "4":
                    cont = true;
                    break;
                default:
                    logger.info("Please Enter A number.");
            }


        }


    }
}