package ApplicationClasses;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.*;





public class User {
    public static final String NAME = "Name: ";
    public static final String ID = "ID: ";
    public static final String DESCRIPTION = "Description: ";
    public static final String PRICE = "Price: ";
    private String username;
    private String address;
    private String phone;
    private String email;
    private String gender;
    private static int productsCounter;
    private double cost;
    boolean logState;
    public static final  String DEC="%d - ";
    private String pass;
    boolean onHold=true;




    protected static final List<User> allUsers = new ArrayList<>() ;//the used list that contains all customers,getC


    protected static Scanner input = new Scanner (System.in);
    static final Logger logger = Logger.getLogger(User.class.getName());


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


    public User() {
        logState=false;

    }





    public void logging(boolean t) {
        logState=t;
    }



    public User(String username,String password, String address, String phone, String email,String gender,double cost) {
        super();
        this.cost=cost;
        this.pass = password;
        this.username = username;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.gender= gender;


    }




    //lists functions , must be static or not?
    public static List<User> getUserList() {
        return allUsers;
    }






    // request functions

/*
    public Request setRequest(String datte,String carModel,Product pr,String location) {
        Request r=new Request();
        this.onHold=true;
        r.preferredDate=datte;
        r.carModel=carModel;
        r.product=pr;
        r.location=location;
        r.setStatus("waiting");

        return r;
    }

*/



    //fields functions
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
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


    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }


    public String getPassword() { return pass; }
    public void setPassword(String password) { this.pass = password; }


    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }



    public String getGender(){
        return gender;
    }




}
