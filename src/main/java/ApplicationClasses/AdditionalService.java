package ApplicationClasses;

import java.util.ArrayList;
import java.util.List;

public  class AdditionalService {
    private String serviceName;
    private double cost;
    public static final List< AdditionalService> availableServices = new ArrayList<>();


    public AdditionalService(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }



    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    public static void initializeAdditionalService(){

        availableServices.add(new AdditionalService("Floral Decoration", 500.0));
        availableServices.add(new AdditionalService("Live Band", 1000.0));
        availableServices.add(new AdditionalService("Photography", 800.0));

    }





    @Override
    public String toString() {
        return "AdditionalService{" +
                "serviceName='" + serviceName + '\'' +
                ", cost=" + cost +
                '}';
    }
}
