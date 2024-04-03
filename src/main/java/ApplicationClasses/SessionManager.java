package ApplicationClasses;



public class SessionManager {
    private static User loggedInUser;
    public static Admin loggedInAdmin;


    public static void loginUser(User user) {
        loggedInUser = user;
    }
    public static void loginAdmin(Admin admin) {
        loggedInAdmin = admin;
    }


    public static User getLoggedInUser() {
        return loggedInUser;
    }


    public static Admin getLoggedInAdmin() {
        return loggedInAdmin;
    }
    public static void logoutUser() {
        loggedInUser = null;
    }
}
