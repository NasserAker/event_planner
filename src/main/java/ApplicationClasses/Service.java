package ApplicationClasses;

import java.util.ArrayList;

public class Service {
    String service_name ;
    double price ;
    String servies_provider_name;

    public static ArrayList <Service> services_list = new ArrayList<>();


    public Service(String service_name , double price , String servies_provider_name ){
        this.service_name = service_name;
        this.price = price;
        this.servies_provider_name = servies_provider_name ;
    }

    public static void add_service (Service service){
        services_list.add(service);
    }


}
