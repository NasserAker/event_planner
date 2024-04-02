package ApplicationClasses;

import java.util.ArrayList;
import java.util.List;

public class ReservationManager {
    private static List<ReservationRequest> reservationRequests = new ArrayList<>();

    public static void addReservationRequest(ReservationRequest request) {
        reservationRequests.add(request);
    }

    public static List<ReservationRequest> getAllReservationRequests() {
        return reservationRequests;
    }
}
