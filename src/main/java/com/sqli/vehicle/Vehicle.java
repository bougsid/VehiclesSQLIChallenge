package com.sqli.vehicle;

import com.sqli.fuel.FuelStrategy;

/**
 * Created by Ayoub BOUGSID on 05/12/2016.
 */
public abstract class Vehicle {

    //Vehicle id
    private String id;
    //Vehicle fuel
    private FuelStrategy fuel;
    //Consumption
    private double consumption;
    //Use boolean array to save doors status
    protected boolean[] doorsStatus;//false = closed, true = open

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FuelStrategy getFuel() {
        return fuel;
    }

    public void setFuel(FuelStrategy fuel) {
        this.fuel = fuel;
    }

    public boolean[] getDoorsStatus() {
        return doorsStatus;
    }

    public void setDoorsStatus(boolean[] doorsStatus) {
        this.doorsStatus = doorsStatus;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    //Open door set status to true
    public void openDoor(int door) {
        this.doorsStatus[door - 1] = true;
    }

    //Check if all doors are closed
    public boolean isAllDoorsClosed() {
        for (boolean status : doorsStatus) {
            if (status) return false;
        }
        return true;
    }
}
