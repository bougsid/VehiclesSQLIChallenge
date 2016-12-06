package com.sqli.fuel;

import com.sqli.configuration.Configuration;

/**
 * Created by Ayoub BOUGSID on 05/12/2016.
 */
//Gasoline Singleton
class Gasoline implements FuelStrategy {

    private static Gasoline instance;

    //To prevent instantiation
    private Gasoline() {
    }

    // Lazy Initialization = If required then only
    static Gasoline getInstance() {
        if (Gasoline.instance == null) {
            // Thread Safe and  double checked locking principle is used
            synchronized (Gasoline.class) {
                if (Gasoline.instance == null) {
                    Gasoline.instance = new Gasoline();
                }
            }
        }
        return Gasoline.instance;
    }

    @Override
    public double getConsumption() {
        return (double) Configuration.GASOLINE_CONSUMPTION/100;
    }
}
