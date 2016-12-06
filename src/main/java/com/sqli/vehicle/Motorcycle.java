package com.sqli.vehicle;

/**
 * Created by ayoub on 12/4/2016.
 */
public class Motorcycle extends Vehicle {
    //Return true because Motorcycle has no doors
    @Override
    public boolean isAllDoorsClosed() {
        return false;
    }
}
