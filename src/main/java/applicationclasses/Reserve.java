package applicationclasses;

public class Reserve {
    private String uname;
    private String cname;
    private String date;
    public Reserve(String unamee, String cnamee, String datee){
        uname =  unamee;
        cname = cnamee;
        date = datee;
    }
    public String getUname(){return uname;}
    public String getCname(){return cname;}
    public String getDate(){return date;}
}
