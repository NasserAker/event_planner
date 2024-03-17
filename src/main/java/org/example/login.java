package org.example;

import java.util.*;
import java.util.logging.Logger;

public class login {
    private boolean isLogged;
    private boolean validation;
    private List<User> up=new ArrayList<>();
    public void addUser(User user) {
        up.add(user);
    }
    public void iAmNotInSystem(login obj)
    {
        obj.isLogged=false;
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
    public void setUnandpass(String name, String pass) {

        for (User u: up) {

            if (name.equals(u.getUserName()) && u.getPass().equals(pass)) {
                validation = true;

                logger.info("hi");
                break;

            }
        }
    }
    public void setInvalidUsernameAndPass(String name, String pass) {
        // Write code here that turns the phrase above into concrete actions
        for (User u: up) {
            if (name.equals(u.getUserName()) && u.getPass().equals(pass)) {
                validation = true; break;
            }
        }
    }
    public void setValidUsernameAndInvalidPass(String name, String pass) {
        for (User u: up) {
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
        for (User u: up) {
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
        for (User user : up) {
            if (user.getUserName().equals(enteredUsername)) {
                user.setPass(newPass);
            }
        }
        for (User user : up) {
            if (user.getUserName().equals(enteredUsername) && user.getPass().equals(newPass)) {
                passwordUpdated = true;
                break;

            }}}
    private  boolean userCreated = false;
    public boolean getUserCreated(){
        return userCreated;
    }
    public void createAcc(String enteredUsername,String enteredPassword){
        for (User user : up) {
            if (user.getUserName().equals(enteredUsername) && user.getPass().equals(enteredPassword)) {
                userCreated = true;
                break;
            }
        }
    }
}
