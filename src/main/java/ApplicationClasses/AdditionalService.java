package ApplicationClasses;

public class AdditionalService {
    private String serviceName;
    private double cost;

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

        AdditionalService floralDecoration = new AdditionalService("Floral Decoration", 500.0);
        AdditionalService liveBand = new AdditionalService("Live Band", 1000.0);
        AdditionalService photography = new AdditionalService("Photography", 800.0);



    }

    @Override
    public String toString() {
        return "AdditionalService{" +
                "serviceName='" + serviceName + '\'' +
                ", cost=" + cost +
                '}';
    }
}
