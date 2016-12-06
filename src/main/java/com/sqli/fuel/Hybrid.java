package com.sqli.fuel;

import com.sqli.configuration.Configuration;

/**
 * Created by Ayoub BOUGSID on 05/12/2016.
 */
//Hybrid Singleton
class Hybrid implements FuelStrategy {
    private static Hybrid instance;

    //To prevent instantiation
    private Hybrid() {
    }

    // Lazy Initialization = If required then only
    static Hybrid getInstance() {
        if (Hybrid.instance == null) {
            // Thread Safe and  double checked locking principle is used
            synchronized (Hybrid.class) {
                if (Hybrid.instance == null) {
                    Hybrid.instance = new Hybrid();
                }
            }
        }
        return Hybrid.instance;
    }

    @Override
    public double getConsumption() {
        return (double) Configuration.HYBRID_CONSUMPTION/100;
    }
}
