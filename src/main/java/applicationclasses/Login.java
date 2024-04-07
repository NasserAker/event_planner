package applicationclasses;

import java.util.*;
import java.util.logging.Logger;

public class Login {
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
//    public void setSubmit(boolean submit){
//        this.submit=submit;
//    }
    public boolean getAvailable1(){
        return available1;
    }
    public boolean getAvailable2(){return available2;}
    public List<UserPlan> getUp() {
        return up;
    }
    private List<UserPlan> up=new ArrayList<>();
    public void addUser(UserPlan user) {
        up.add(user);
    }

    public void iAmNotInSystem(Login obj)
    {
        obj.isLogged=false;
    }
    public void iMTheAdmin(Login obj)
    {
        obj.isLogged=true;
    }
    public void imthecustomer(Login obj)
    {
        obj.isLogged=true;
    }
    public void imtheserverprovider(Login obj)
    {
        obj.isLogged=true;
    }

//    public void setNamePass(String userName, String pass){
//        for (UserPlan u: up) {
//            if (userName.equals(u.getUserName()) && u.getPass().equals(pass)) {
//                validation = true;
//                break;
//            }
//        }
//    }

    private static final Logger logger = Logger.getLogger(Login.class.getName());
//    public boolean getIsLogged(){
//        return  isLogged;
//    }
    public void setLogged(boolean isLogged){
        this.isLogged=isLogged;
    }
    public boolean getValidation(){
        return validation;
    }
    private  List<EventPlan> ev = new  ArrayList<>();
    public List<EventPlan> getev() {
        return ev;
    }
    private  List<String>date = new  ArrayList<>();
    public List<String> getDate() {
        return date;
    }
    public void addDate(String dates) {
        date.add(dates);
    }
    public void addevent(EventPlan event) {
        ev.add(event);
    }
    public Login()
    {
        UserPlan u1= new UserPlan("hala","123","7\3\2004");
        up.add(u1);
        UserPlan u2= new UserPlan("magichala.koni@gmail.com","1234","7\3\2004");
        up.add(u2);
        this.isLogged = false;
        this.validation = false;

    }
    public void setUnandpass(String name, String pass) {

        for (UserPlan u: up) {

            if (name.equals(u.getUserName()) && u.getPass().equals(pass)) {
                validation = true;

                logger.info("hi");
                break;

            }
        }
    }
    public void setInvalidUsernameAndPass(String name, String pass) {
        // Write code here that turns the phrase above into concrete actions
        for (UserPlan u: up) {
            if (name.equals(u.getUserName()) && u.getPass().equals(pass)) {
                validation = true; break;
            }
        }
    }
    public void setValidUsernameAndInvalidPass(String name, String pass) {
        for (UserPlan u: up) {
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
        for (UserPlan u: up) {
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
        for (UserPlan user : up) {
            if (user.getUserName().equals(enteredUsername)) {
                user.setPass(newPass);
            }
        }
        for (UserPlan user : up) {
            if (user.getUserName().equals(enteredUsername) && user.getPass().equals(newPass)) {
                passwordUpdated = true;
                break;

            }
        }
    }
    private  boolean userCreated = false;
    public boolean getUserCreated(){
        return userCreated;
    }
    public void createAcc(String enteredUsername,String enteredPassword){
        for (UserPlan user : up) {
            if (user.getUserName().equals(enteredUsername) && user.getPass().equals(enteredPassword)) {
                userCreated = true;
                break;
            }
        }
    }
    public void seeUser()
    {
        for(UserPlan c:up)
        {

            logger.info("Gmail:- "+c.getUserName() +"\t"+"Password:- "+c.getPass()+"\t"+"BirthDate:- "+c.getB());
        }
    }
    public void event(String name, int price, int ava, String desc,String location, int time,String theme) {
        ev.add(new EventPlan(name, price, ava, desc,location,time,theme));

        logger.info("You have added the event successfully ");
    }
    private int exist=0;
    public void setE(){exist=1;}
    public int getE(){return exist;}
    public void addeve(String name){
        for(EventPlan c:ev) {
            if ((c.geteventName()).equals(name)) {
                setE();
                break;
            }
        }
    }
    int y=0;
    public int update(String name,String pass) {
        for (UserPlan u : getUp()) {
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
        for(EventPlan c:ev)
        {
            if((c.geteventName()).equals(name)) {
                c.setPrice(newprice);
                setCheck();
            }
        }
    }
    public void searchbyname(String name) {
        for(EventPlan c: ev ){
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
            }
        }
    }


    public void printCatalog(EventPlan cc){
        logger.info(cc.getDescrtion());
        String k=String.valueOf(cc.getPrice());
        logger.info(k);
        String kk=String.valueOf(cc.getAvailable());
        logger.info(kk);
    }
    private List<EventPlan> eventArrayList = new ArrayList<>();
    public List<EventPlan> geteventArrayList() {
        return eventArrayList;
    }
    public void requestByPrice(int price){
        for(EventPlan c: getev() ){
            if(price==c.getPrice()){
                eventArrayList.add(new EventPlan(c.geteventName(),c.getPrice(),c.getAvailable(),c.getDescrtion(),c.getlocation(),c.gettime(),c.gettheme()));
            }
        }
    }
    private   List<Reserve> op = new  ArrayList<>();
    public List<Reserve> getOp() {
        return op;
    }
//    public void addres(Reserve order) {
//        op.add(order);
//    }
//    private String dateee ;
//    private String cname;
//    public String getDateee(){
//        return dateee;
//    }
//    public String getCname(){
//        return cname;
//    }
//    public void fillModelAndDate(String model,String datee){
//        for(String d: getDate()){
//            if (d.equals(datee)) {
//                available1 = true;
//                dateee = datee;
//                break;
//            }
//        }
//        for(EventPlan c : ev){
//            if (model.equals(c.geteventName())){
//                available2 = true;
//                cname = model;
//                break;
//            }
//        }
//    }
    private boolean updates = false;
    private boolean appear = true;
    public boolean getUpdates(){
        return updates;
    }
    public boolean getApear(){
        return appear;
    }
    public void updatesSuccessfully(String name,String pass){
        for(UserPlan u: up){
            if(name.equals(u.getUserName())){
                u.setPass(pass);
                updates = true;
                break;
            }
        }
    }

    public void appearInformation(String name){
        for(Reserve o : getOp()){
            if(name.equals(o.getUname())){
                logger.info(o.getCname());
                logger.info(o.getDate());
                appear = true;
            }
        }
    }
    public void catagoryadd(String name, int price, int ava, String desc,String location ,int time,String theme) {
        ev.add(new EventPlan(name, price, ava, desc,location,time,theme));

        logger.info("You have added this event a successfully way");
    }

}
