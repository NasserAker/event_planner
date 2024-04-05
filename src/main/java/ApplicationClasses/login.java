package ApplicationClasses;

import java.util.*;
import java.util.logging.Logger;

public class login {
    private boolean isLogged;
    private boolean validation;
    private boolean available1 = false;
    private boolean available2 = false;
    private   boolean isreserved=false;
    public boolean getreservation(){
        return isreserved;
    }
    public void setreserve(boolean res){
        this.isreserved=res;
    }
    private boolean submit = false;
    public boolean getSubmit(){
        return submit;
    }
    public void setSubmit(boolean submit){
        this.submit=submit;
    }
    public boolean getAvailable1(){
        return available1;
    }
    public boolean getAvailable2(){return available2;}
    public List<user> getUp() {
        return up;
    }
    private List<user> up=new ArrayList<>();
    public void addUser(user user) {
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
    public void imthecustomer(login obj)
    {
        obj.isLogged=true;
    }
    public void imtheserverprovider(login obj)
    {
        obj.isLogged=true;
    }

    public void setNamePass(String userName, String pass){
        for (user u: up) {
            if (userName.equals(u.getUserName()) && u.getPass().equals(pass)) {
                validation = true;
                break;
            }
        }
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
        user u1= new user("hala","123","7\3\2004");
        up.add(u1);
        user u2= new user("magichala.koni@gmail.com","1234","7\3\2004");
        up.add(u2);
        this.isLogged = false;
        this.validation = false;

    }
    public void setUnandpass(String name, String pass) {

        for (user u: up) {

            if (name.equals(u.getUserName()) && u.getPass().equals(pass)) {
                validation = true;

                logger.info("hi");
                break;

            }
        }
    }
    public void setInvalidUsernameAndPass(String name, String pass) {
        // Write code here that turns the phrase above into concrete actions
        for (user u: up) {
            if (name.equals(u.getUserName()) && u.getPass().equals(pass)) {
                validation = true; break;
            }
        }
    }
    public void setValidUsernameAndInvalidPass(String name, String pass) {
        for (user u: up) {
            if (name.equals(u.getUserName()) && u.getPass().equals(pass)) {
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
        for (user u: up) {
            if (userName.equals(u.getUserName()) && pass.equals("Forget")) {
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
        for (ApplicationClasses.user user : up) {
            if (user.getUserName().equals(enteredUsername)) {
                user.setPass(newPass);
            }
        }
        for (ApplicationClasses.user user : up) {
            if (user.getUserName().equals(enteredUsername) && user.getPass().equals(newPass)) {
                passwordUpdated = true;
                break;

            }}}
    private  boolean userCreated = false;
    public boolean getUserCreated(){
        return userCreated;
    }
    public void createAcc(String enteredUsername,String enteredPassword){
        for (ApplicationClasses.user user : up) {
            if (user.getUserName().equals(enteredUsername) && user.getPass().equals(enteredPassword)) {
                userCreated = true;
                break;
            }
        }
    }
    public void seeUser()
    {
        for(user c:up)
        {

            logger.info("Gmail:- "+c.getUserName() +"\t"+"Password:- "+c.getPass()+"\t"+"BirthDate:- "+c.getB());
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
        for (user u : getUp()) {
            if (name.equals(u.getUserName())) {
                u.setPass(pass);
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
        for (Iterator<user> iterator = up.iterator(); iterator.hasNext();) {
            user user = iterator.next();
            if (user.getUserName().equals(username)) {
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
    public void printCatalog(event cc){
        logger.info(cc.getDescrtion());
        String k=String.valueOf(cc.getPrice());
        logger.info(k);
        String kk=String.valueOf(cc.getAvailable());
        logger.info(kk);
    }
    private List<event> eventArrayList = new ArrayList<>();
    public List<event> geteventArrayList() {
        return eventArrayList;
    }
    public void requestByPrice(int price){
        for(event c: getev() ){
            if(price==c.getPrice()){
                eventArrayList.add(new event(c.geteventName(),c.getPrice(),c.getAvailable(),c.getDescrtion(),c.getlocation(),c.gettime(),c.gettheme()));
            }
        }
    }
    private   List<reserve> op = new  ArrayList<>();
    public List<reserve> getOp() {
        return op;
    }
    public void addres(reserve order) {
        op.add(order);
    }
    private String dateee ;
    private String cname;
    public String getDateee(){
        return dateee;
    }
    public String getCname(){
        return cname;
    }
    public void fillModelAndDate(String model,String datee){
        for(String d: getDate()){
            if (d.equals(datee)) {
                available1 = true;
                dateee = datee;
                break;
            }
        }
        for(event c : ev){
            if (model.equals(c.geteventName())){
                available2 = true;
                cname = model;
                break;
            }
        }
    }
    private boolean updates = false;
    private boolean appear = true;
    public boolean getUpdates(){
        return updates;
    }
    public boolean getApear(){
        return appear;
    }
    public void updatesSuccessfully(String name,String pass){
        for(user u: up){
            if(name.equals(u.getUserName())){
                u.setPass(pass);
                updates = true;
                break;
            }
        }
    }
    int yuy=0;
    public int yourInformationUpdatesSuccessfully(String name,String pass) {
        for (user u : getUp()) {
            if (name.equals(u.getUserName())) {
                u.setPass(pass);
                yuy=1;
                break;
            }
        }
        return yuy;
    }
    public void appearInformation(String name){
        for(reserve o : getOp()){
            if(name.equals(o.getUname())){
                logger.info(o.getCname());
                logger.info(o.getDate());
                appear = true;
            }
        }
    }
    public void catagoryadd(String name, int price, int ava, String desc,String location ,int time,String theme) {
        ev.add(new event(name, price, ava, desc,location,time,theme));

        logger.info("You have added this event a successfully way");
    }

}
