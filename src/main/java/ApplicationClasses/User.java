package ApplicationClasses;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String address;
    private String phone;
    private String email;
    private String gender;

    private String password;
 

    private static final List<User> allUsers = new ArrayList<>();

    public User(String username, String password, String address, String phone, String email, String gender, double cost) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
       
    }

    public static List<User> getUserList() {
        return allUsers;
    }

    public static void initializeUsers() {
        User r1 = new User("sara", "111", "QAM", "02872228", "sara@gmail.com", "Female", 0.0);
        allUsers.add(r1);
        Logging.getQ().put(r1.getEmail(), r1.getPassword());

        // Add more users as needed
    }



    // Getters and setters for all properties

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
