package ApplicationClasses;


import java.util.ArrayList;
import java.util.List;

public class Admin {


    boolean logState;
    private String password;
    private String username;
    private String email;


    protected static final List<Admin> adminList = new ArrayList<>() ;

    public Admin() {logState=false;}

    public Admin(String email, String name,String password) {
        this.password= password;
        this.username = name;
        this.email = email;
    }

    public static List<Admin> getAdminList() {
        return adminList;
    }


    public static void initializeAdmin(String email, String username, String password) {
        //Admin admin = new Admin(email, username, password);
        //Admin.getAdminList().add(admin);
        //Logging.getQ().put(admin.getEmail(), admin.getPassword());
            Admin admin1 = new Admin("admin1@example.com", "admin1", "password1");
            Admin admin2 = new Admin("admin2@example.com", "admin2", "password2");
            Admin admin3 = new Admin("admin3@example.com", "admin3", "password3");
            Admin admin4 = new Admin("admin4@example.com", "admin4", "password4");

            adminList.add(admin1);
            adminList.add(admin2);
            adminList.add(admin3);
            adminList.add(admin4);

            // Optionally, populate the Logging queue as well
            Logging.getQ().put(admin1.getEmail(), admin1.getPassword());
            Logging.getQ().put(admin2.getEmail(), admin2.getPassword());
            Logging.getQ().put(admin3.getEmail(), admin3.getPassword());
            Logging.getQ().put(admin4.getEmail(), admin4.getPassword());


    }
    public String getPassword() {return password;}
    public void logging(boolean t) { logState=t; }
    public String getName() {return username;}
    public String getEmail(){return email;}
}
