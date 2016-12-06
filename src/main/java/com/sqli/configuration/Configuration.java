package com.sqli.configuration;

/**
 * Created by Ayoub BOUGSID on 05/12/2016.
 */
//App Configuration (Create const variables to represent app config)
public interface Configuration {

    //General Configuration
    String VEHICLE_SEPARATOR = ",";
    String DETAILS_SEPARATOR = ":";

    //Vehicle Types
    String CAR = "CAR";
    String TRUCK = "TRUCK";
    String MOTORCYCLE = "MOTORCYCLE";

    //Fuel Types
    String DIESEL = "Diesel";
    String GASOLINE = "Gasoline";
    String HYBRID = "Hybrid";

    //Consumption values depending on fuel type
    int DIESEL_CONSUMPTION = 5;
    int GASOLINE_CONSUMPTION = 6;
    int HYBRID_CONSUMPTION = 3;
}
