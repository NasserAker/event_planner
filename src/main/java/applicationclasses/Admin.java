package applicationclasses;


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


    public static void initializeAdmin() {
            Admin admin1 = new Admin("s12028604@stu.najah.edu", "Raya Break", "1235");
            Admin admin2 = new Admin("nasseraker4@gmail.com", "Nasser", "1234");
            Admin admin3 = new Admin("admin3@example.com", "admin3", "123");
            Admin admin4 = new Admin("admin4@example.com", "admin4", "12");

            adminList.add(admin1);
            adminList.add(admin2);
            adminList.add(admin3);
            adminList.add(admin4);


            Logging.getQ().put(admin1.getEmail(), admin1.getPassword());
            Logging.getQ().put(admin2.getEmail(), admin2.getPassword());
            Logging.getQ().put(admin3.getEmail(), admin3.getPassword());
            Logging.getQ().put(admin4.getEmail(), admin4.getPassword());


    }
    public String getPassword() {return password;}
    public void logging(boolean t) { logState=t; }

    public String getEmail(){return email;}
    public static Admin getAdminByEmail(String email) {
        for (Admin admin : Admin.getAdminList()) {
            if (admin.getEmail().equals(email)) {
                return admin;
            }
        }
        return null;
    }

    public String getUsername() {
        return username;
    }
}
