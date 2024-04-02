package ApplicationClasses;

import io.cucumber.java.tr.Ve;

import java.util.ArrayList;
import java.util.UUID;

public class ReservationRequest {
    private int requestId;
    int customerId;
    String customer_name = "";

    Venue venue;

    public ReservationRequest(int id , int csut_id , String cust_name , Venue venue){
        this.requestId = id ;
        this.customer_name = cust_name;
        this.customerId = csut_id;
        this.venue = venue;
    }
    public ReservationRequest(){
        this.requestId = -1 ;
        this.customer_name = "No Name";
        this.customerId = -1;
    }

     public static final ArrayList<ReservationRequest> RequestList = new ArrayList<ReservationRequest>();
    public static final ArrayList<ReservationRequest> ApprovedRequests = new ArrayList<ReservationRequest>();
    public static final ArrayList<ReservationRequest> DeniedRequests = new ArrayList<ReservationRequest>();

    public boolean IsPending(){
        return RequestList.contains(this);
    }


    public int RequestCount(){
        return RequestList.size();
    }

    public Integer SelectRequest(int index){
        Integer item  =-1  ;
        for(ReservationRequest request : RequestList ){
            if(request.requestId == index){
                item = RequestList.get(index).requestId;
            }
        }
        return item;
    }

    public void ApproveRequest(){
        ApprovedRequests.add(this);
        RequestList.remove(this);
    }

    public void DenyRequest( ){
        DeniedRequests.add(this);
        RequestList.remove(this);
    }

    public boolean Confirmation(){
        return ApprovedRequests.contains(this);
    }

    public boolean Denial(){
        return DeniedRequests.contains(this);
    }

    public int GetRequestId(){
        return requestId;
    }
    public String Getname(){
        return customer_name;
    }
    public int GetcustId(){
        return customerId;
    }
    public String getusername() {
        return this.customer_name;
    }
}
