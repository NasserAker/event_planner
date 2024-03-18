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

    public static List<Admin> getAdminList() {return adminList;}
    public String getPassword() {return password;}
    public void logging(boolean t) { logState=t; }
    public String getName() {return username;}
    public String getEmail(){return email;}
}
