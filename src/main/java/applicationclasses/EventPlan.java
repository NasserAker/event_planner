package applicationclasses;

public class EventPlan {
    private String eventName;
    private int price;
    private int availablity;
    private String describtion;
    private String location;
    private int time;
    private String theme;
    public EventPlan(String name, int price, int aval, String desc, String loc, int time, String theme){
        eventName =name;
        this.price=price;
        availablity=aval;
        describtion=desc;
        location=loc;
        this.time=time;
        this.theme=theme;
    }
    public EventPlan(){
        eventName ="";
        price=0;
        availablity=0;
        describtion="";
        location="";
        time=0;
        theme="";
    }
    //public int getPrice() {
      //  return price;
    //}

    public int getAvailable() {
        return availablity;
    }

    public String geteventName() {
        return eventName;
    }



    public String getDescrtion() {
        return describtion;
    }
    public String getlocation() {
        return location;
    }
    public String gettheme() {
        return theme;
    }

    public int gettime() {
        return time;
    }

    //public void setAvailable(int available) {
      //  this.availablity = available;
    //}

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
