package applicationclasses;

import java.util.ArrayList;
import java.util.List;

public class Service {
    String servicename ;
    double price ;
    String servies_provider_name;

    public static final List<Service> serviceslist = new ArrayList<>();


    public Service(String service_name , double price , String servies_provider_name ){
        this.servicename = service_name;
        this.price = price;
        this.servies_provider_name = servies_provider_name ;
    }

    public static void add_service (Service service){
        serviceslist.add(service);
    }


}
