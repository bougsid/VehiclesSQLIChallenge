package com.sqli.vehicle;

import static com.sqli.configuration.Configuration.*;

/**
 * Created by ayoub on 12/4/2016.
 */

//Factory pattern
public class VehicleFactory {
    //Instantiate Vehicle depending on the type
    public static Vehicle getVehicle(String type) {
        switch (type) {
            case CAR:
                return new Car();
            case TRUCK:
                return new Truck();
            case MOTORCYCLE:
                return new Motorcycle();
            default: {
                return null;
            }
        }
    }
}
