package com.sqli.fuel;

import com.sqli.configuration.Configuration;

/**
 * Created by Ayoub BOUGSID on 05/12/2016.
 */
//Diesel Singleton
public class Diesel implements FuelStrategy {

    private static Diesel instance;

    //To prevent instantiation
    private Diesel() {
    }

    // Lazy Initialization = If required then only
    static Diesel getInstance() {
        if (Diesel.instance == null) {
            // Thread Safe and  double checked locking principle is used
            synchronized (Diesel.class) {
                if (Diesel.instance == null) {
                    Diesel.instance = new Diesel();
                }
            }
        }
        return Diesel.instance;
    }

    @Override
    public double getConsumption() {
        return (double) Configuration.DIESEL_CONSUMPTION / 100;
    }
}
