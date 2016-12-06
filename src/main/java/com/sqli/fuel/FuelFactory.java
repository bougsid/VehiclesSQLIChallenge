package com.sqli.fuel;

import static com.sqli.configuration.Configuration.*;

/**
 * Created by Ayoub BOUGSID on 05/12/2016.
 */
//Factory pattern
public class FuelFactory {
    public static FuelStrategy getFuel(String fuelType)  {
        switch (fuelType) {
            case DIESEL: {
                return Diesel.getInstance();
            }
            case GASOLINE: {
                return Gasoline.getInstance();
            }
            case HYBRID: {
                return Hybrid.getInstance();
            }
            default: {
                return null;
            }
        }
    }
}
