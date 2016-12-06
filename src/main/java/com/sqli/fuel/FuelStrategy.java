package com.sqli.fuel;

/**
 * Created by Ayoub BOUGSID on 05/12/2016.
 */

//Strategy pattern
public interface FuelStrategy {
    //Return consumption depending on fuel type
    double getConsumption();
}
