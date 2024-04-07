package applicationclasses;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

public class ReservationRequest {
    private int requestId;
    private applicationclasses.User user;
    private applicationclasses.Venue venue;
    private applicationclasses.Date date;
    private List<AdditionalService> services;

    public ReservationRequest(int requestId, User user, Venue venue, Date date, List<AdditionalService> services) {
        this.requestId = requestId;
        this.user = user;
        this.venue = venue;
        this.date = date;
        this.services = services;
    }

    public static final List<ReservationRequest> RequestList = new ArrayList<>();
    private static final List<ReservationRequest> ApprovedRequests = new ArrayList<>();
    private static final List<ReservationRequest> DeniedRequests = new ArrayList<>();

    public static List<ReservationRequest> getAllReservationRequests() {
        return Collections.unmodifiableList(RequestList);
    }

    public void approveRequest() {
        ApprovedRequests.add(this);
        RequestList.remove(this);
    }

    public void denyRequest() {
        DeniedRequests.add(this);
        RequestList.remove(this);
    }

    public boolean isConfirmed() {
        return ApprovedRequests.contains(this);
    }

    public boolean isDenied() {
        return DeniedRequests.contains(this);
    }

    public static void addReservationRequest(ReservationRequest request) {
        RequestList.add(request);
    }


    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public List<AdditionalService> getServices() {
        return services;
    }

    public void setServices(List<AdditionalService> services) {
        this.services = services;
    }


    public static List<ReservationRequest> getRequestList() {
        return RequestList;
    }

    public static List<ReservationRequest> getApprovedRequests() {
        return ApprovedRequests;
    }

    public static List<ReservationRequest> getDeniedRequests() {
        return DeniedRequests;
    }

    @Override
    public String toString() {
        return "ReservationRequest{" +
                "requestId=" + requestId +
                ", user=" + user +
                ", venue=" + venue +
                ", date=" + date +
                ", services=" + services +
                '}';
    }
}
