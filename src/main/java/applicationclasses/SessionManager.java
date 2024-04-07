package applicationclasses;



public class SessionManager {

    // Private constructor to prevent instantiation
    private SessionManager() {
        // Optional: You can throw an exception here if someone tries to instantiate the class
        throw new UnsupportedOperationException("SessionManager cannot be instantiated");
    }

    private static User loggedInUser;
    private static Admin loggedInAdmin;
    private static ServiceProvider loggedInServiceProvider;


    public static void loginUser(User user) {
        loggedInUser = user;
    }

    public static void loginAdmin(Admin admin) {
        loggedInAdmin = admin;
    }

    public static void loginServiceProvider(ServiceProvider serviceProvider) {
        loggedInServiceProvider = serviceProvider;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }


    public static Admin getLoggedInAdmin() {
        return loggedInAdmin;
    }



    public static ServiceProvider getLoggedInServiceProvider() {
        return loggedInServiceProvider;
    }


    public static void logoutUser() {
        // Logout logic for users
        loggedInUser = null;
    }

    public static void logoutAdmin() {
        // Logout logic for admins
        loggedInAdmin = null;
    }

    public static void logoutServiceProvider() {
        loggedInServiceProvider = null;
    }
}