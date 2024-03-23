package ApplicationClasses;

import java.util.ArrayList;
import java.util.UUID;

public class ReservationRequest {
    private int requestId;
    int customerId;
    private final UUID uniqueId;

    

    public ReservationRequest() {
        this.uniqueId = UUID.randomUUID();
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
        return ApprovedRequests.contains(this.requestId);
    }

    public boolean Denial(){
        return DeniedRequests.contains(this.requestId);
    }

    public int GetRequestId(){
        return requestId;
    }
}
