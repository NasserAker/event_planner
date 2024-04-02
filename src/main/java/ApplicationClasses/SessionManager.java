package ApplicationClasses;



public class SessionManager {
    private static User loggedInUser;

    public static void loginUser(User user) {
        loggedInUser = user;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void logoutUser() {
        loggedInUser = null;
    }
}
