package ApplicationClasses;

import java.util.ArrayList;

public class ReservationRequest {
    int requestId;
    int customerId;

    public static final ArrayList<Integer> RequestList = new ArrayList<Integer>();
    public static final ArrayList<Integer> ApprovedRequests = new ArrayList<Integer>();
    public static final ArrayList<Integer> DeniedRequests = new ArrayList<Integer>();

    public boolean IsPending(){
        return RequestList.contains(requestId);
    }

    public void ApproveRequest(){
        ApprovedRequests.add(this.requestId);
        RequestList.remove(this.requestId);
    }

    public void DenyRequest( ){
        DeniedRequests.add(this.requestId);
        RequestList.remove(this.requestId);
    }

    public void sendConfirmation(){

    }

    public void sendDenial(){

    }

    public int GetRequestId(){
        return requestId;
    }
}
