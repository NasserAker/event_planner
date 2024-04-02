package ApplicationClasses;

import java.util.List;

public class ReservationRequest {
    private Venue selectedVenue;
    private Date selectedDate;
    private List<AdditionalService> selectedServices;
    private User user;

    public ReservationRequest(Venue selectedVenue, Date selectedDate, List<AdditionalService> selectedServices, User user) {
        this.selectedVenue = selectedVenue;
        this.selectedDate = selectedDate;
        this.selectedServices = selectedServices;
        this.user = user;
    }

    public Venue getSelectedVenue() {
        return selectedVenue;
    }

    public void setSelectedVenue(Venue selectedVenue) {
        this.selectedVenue = selectedVenue;
    }

    public Date getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(Date selectedDate) {
        this.selectedDate = selectedDate;
    }

    public List<AdditionalService> getSelectedServices() {
        return selectedServices;
    }

    public void setSelectedServices(List<AdditionalService> selectedServices) {
        this.selectedServices = selectedServices;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Venue: ").append(selectedVenue.getName()).append("\n");
        sb.append("Date: ").append(selectedDate).append("\n");
        sb.append("Services: ").append(selectedServices).append("\n");
        sb.append("Requested by: ").append(user.getUsername()).append("\n");
        return sb.toString();
    }
}
