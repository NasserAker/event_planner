package applicationclasses;

public class event {
    private String eventName;
    private int price;
    private int availablity;
    private String describtion;
    public event(String name, int price, int aval, String desc){
      eventName =name;
        this.price=price;
        availablity=aval;
        describtion=desc;
    }
    public event(){
        eventName ="";
        price=0;
        availablity=0;
        describtion="";
    }
    public int getPrice() {
        return price;
    }

    public int getAvailable() {
        return availablity;
    }

    public String geteventName() {
        return eventName;
    }

    public String getDescrtion() {
        return describtion;
    }

    public void setAvailable(int available) {
        this.availablity = available;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
