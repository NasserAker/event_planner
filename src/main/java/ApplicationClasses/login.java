package ApplicationClasses;

import java.util.*;
import java.util.logging.Logger;

public class login {
    private boolean isLogged;
    private boolean validation;
    public List<User> getUp() {
        return up;
    }
    private List<User> up=new ArrayList<>();
    public void addUser(User user) {
        up.add(user);
    }

    public void iAmNotInSystem(login obj)
    {
        obj.isLogged=false;
    }
    public void iMTheAdmin(login obj)
    {
        obj.isLogged=true;
    }
    private static final Logger logger = Logger.getLogger(login.class.getName());
    public boolean getIsLogged(){
        return  isLogged;
    }
    public void setLogged(boolean isLogged){
        this.isLogged=isLogged;
    }
    public boolean getValidation(){
        return validation;
    }
    private  List<event> ev = new  ArrayList<>();
    public List<event> getev() {
        return ev;
    }
    private  List<String>date = new  ArrayList<>();
    public List<String> getDate() {
        return date;
    }
    public void addDate(String dates) {
        date.add(dates);
    }
    public void addevent(event event) {
        ev.add(event);
    }
    public login()
    {
        User u1= new User("hala","123","7\3\2004");
        up.add(u1);
        User u2= new User("magichala.koni@gmail.com","1234","7\3\2004");
        up.add(u2);
        this.isLogged = false;
        this.validation = false;

    }
    public void setUnandpass(String name, String pass) {

        for (User u: up) {

            if (name.equals(u.getUsername()) && u.getPassword().equals(pass)) {
                validation = true;

                logger.info("hi");
                break;

            }
        }
    }
    public void setInvalidUsernameAndPass(String name, String pass) {
        // Write code here that turns the phrase above into concrete actions
        for (User u: up) {
            if (name.equals(u.getUsername()) && u.getPassword().equals(pass)) {
                validation = true; break;
            }
        }
    }
    public void setValidUsernameAndInvalidPass(String name, String pass) {
        for (User u: up) {
            if (name.equals(u.getUsername()) && u.getPassword().equals(pass)) {
                validation = true; break;
            }
        }
    }
    public void setEmptyUsernameAndPass(String name, String pass) {
        if (name.isEmpty() && !pass.isEmpty())
            validation = false;
    }
    public void setValidUsernameAndEmptyPass(String name, String pass) {
        if (pass.isEmpty()&& !name.isEmpty())
            validation = false;
    }
    private boolean forget = false;
    public void setForget(boolean forget){
        this.forget=forget;
    }
    private String enteredUsername;
    public boolean getForget(){
        return forget;
    }
    public String getEnteredUsername(){
        return enteredUsername;
    }
    public void validUserPass(String userName, String pass){
        setForget(false);
        for (User u: up) {
            if (userName.equals(u.getUsername()) && pass.equals("Forget")) {
                setForget(true);
                enteredUsername = userName;
                break;

            }
        }
    }
    private boolean passwordUpdated = false;
    public boolean getPasswordUpdated(){
        return passwordUpdated;
    }
    public void takePass(String newPass){
        for (User user : up) {
            if (user.getUsername().equals(enteredUsername)) {
                user.setPassword(newPass);
            }
        }
        for (User user : up) {
            if (user.getUsername().equals(enteredUsername) && user.getPassword().equals(newPass)) {
                passwordUpdated = true;
                break;

            }}}
    private  boolean userCreated = false;
    public boolean getUserCreated(){
        return userCreated;
    }
    public void createAcc(String enteredUsername,String enteredPassword){
        for (User user : up) {
            if (user.getUsername().equals(enteredUsername) && user.getPassword().equals(enteredPassword)) {
                userCreated = true;
                break;
            }
        }
    }
    public void seeUser()
    {
        for(User c:up)
        {

            logger.info("Gmail:- "+c.getUsername() +"\t"+"Password:- "+c.getPassword()+"\t"+"BirthDate:- "+c.getB());
        }
    }
    public void event(String name, int price, int ava, String desc,String location, int time,String theme) {
        ev.add(new event(name, price, ava, desc,location,time,theme));

        logger.info("You have added the event successfully ");
    }
    private int exist=0;
    public void setE(){exist=1;}
    public int getE(){return exist;}
    public void addeve(String name){
        for(event c:ev)
        {
            if ((c.geteventName()).equals(name)) {
                setE();
                break;
            }
        }
    }
    int y=0;
    public int update(String name,String pass) {
        for (User u : getUp()) {
            if (name.equals(u.getUsername())) {
                u.setPassword(pass);
                y=1;
                break;
            }
        }
        return y;
    }
    private int checkPrice =0;
    public int getCheck(){return checkPrice;}
    public void setCheck(){checkPrice=1;}
    public void newPrice(String name, int newprice){
        for(event c:ev)
        {
            if((c.geteventName()).equals(name)) {
                c.setPrice(newprice);
                setCheck();
            }
        }
    }
    public void searchbyname(String name) {
        for(event c: ev ){
            if(name.equals(c.geteventName())){
                String k=String.valueOf(c.getPrice());
                String f=String.valueOf(c.getAvailable());

                logger.info("Price:- ");
                logger.info(k);
                logger.info("The num of available halls:- ");
                logger.info(f);
                logger.info("Discribtion about it:- "+c.getDescrtion());
                logger.info("location:- "+c.getlocation());
                logger.info("time:- "+c.gettime());
                logger.info("theme:- "+c.gettheme());
            }
        }
    }
    public int deleteUserByUsername(String username) {
        for (Iterator<User> iterator = up.iterator(); iterator.hasNext();) {
            User user = iterator.next();
            if (user.getUsername().equals(username)) {
                iterator.remove();
                return 1;
            }
        }
        return 0;
    }
    public int deleteEventByName(String eventName) {
        for (Iterator<event> iterator = ev.iterator(); iterator.hasNext();) {
            event e = iterator.next();
            if (e.geteventName().equals(eventName)) {
                iterator.remove();
                return 1; // Indicates successful deletion
            }
        }
        return 0; // Indicates event not found
    }
    public int findEventIndexByName(String eventName) {
        for (int i = 0; i < ev.size(); i++) {
            if (ev.get(i).geteventName().equals(eventName)) {
                return i; // Return the index of the event if found
            }
        }
        return -1; // Return -1 if the event is not found
    }

    public void editEvent(int index, String newName, int newPrice, int newAvailability, String newDescription, String newLocation, int newTime, String newTheme) {
        event e = ev.get(index);
        e.seteventName(newName);
        e.setPrice(newPrice);
        e.setAvailable(newAvailability);
        e.setDescrtion(newDescription);
        e.setlocation(newLocation);
        e.settime(newTime);
        e.settheme(newTheme);
    }
}
