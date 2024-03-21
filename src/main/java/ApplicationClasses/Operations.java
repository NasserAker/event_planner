package ApplicationClasses;

public class Operations {


    public static boolean addUser(User c) {
        boolean add=true;
        for(int i = 0; i< User.getUserList().size() ; i++) {
            if((User.getUserList().get(i).getEmail().equals(c.getEmail()))||((User.getUserList().get(i).getEmail().equals(c.getEmail())) && (User.getUserList().get(i).getUsername().equals(c.getUsername())) && (User.getUserList().get(i).getAddress().equals(c.getAddress()))&& (User.getUserList().get(i).getPhone().equals(c.getPhone()))))
            {
                add = false;
                break;
            }
        }
        if(add) {
            User.getUserList().add(c);
        }
        return add;
    }

}
