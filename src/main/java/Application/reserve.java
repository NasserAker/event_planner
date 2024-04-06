package Application;

public class reserve {
    private String uname;
    private String cname;
    private String date;

    public reserve(String unamee, String cnamee, String datee){
        uname =  unamee;
        cname = cnamee;
        date = datee;
    }
    public String getUname(){return uname;}
    public String getCname(){return cname;}
    public String getDate(){return date;}
}
