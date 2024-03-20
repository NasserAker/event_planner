package ApplicationClasses;

import java.util.ArrayList;

public class ReservationRequest {
    private int requestId;
    int customerId;

    public static final ArrayList<Integer> RequestList = new ArrayList<Integer>();
    public static final ArrayList<Integer> ApprovedRequests = new ArrayList<Integer>();
    public static final ArrayList<Integer> DeniedRequests = new ArrayList<Integer>();

    public boolean IsPending(){
        return RequestList.contains(requestId);
    }


    public int RequestCount(){
        return RequestList.size();
    }

    public Integer SelectRequest(int index){
        Integer item ;
        item = RequestList.get(index);
        return item;
    }

    public void ApproveRequest(){
        ApprovedRequests.add(this.requestId);
        RequestList.remove(this.requestId);
    }

    public void DenyRequest( ){
        DeniedRequests.add(this.requestId);
        RequestList.remove(this.requestId);
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
