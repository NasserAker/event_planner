package org.example;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class login {
    private boolean log=false;

    public void setlogin(boolean b) {
        log=b;
    }
    protected static Map<String,String> q= new HashMap<>();//how to make it protected
    public Map<String,String> getQ() {
        return q;

    }
    private static int i;
    public static void setY(int i) {
        login.i=i;
    }
}
