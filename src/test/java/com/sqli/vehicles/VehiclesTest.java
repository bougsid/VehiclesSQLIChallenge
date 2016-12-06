package com.sqli.vehicles;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/************
 The aim of the exercise is to pass all the test cases bellow.
 It's about vehicles and their consumption. Each vehicle has a different consumption according to its Fuel type :
 - Diesel: 5%
 - Gasoline: 6%
 - Hybrid: 3%

 There are three categories of vehicles :
 * CAR has 4 doors
 * TRUCK has 2 doors
 * MOTORCYCLE has no doors

 A vehicle with 4 doors is displayed as bellow. Please respect the door's numbers as in the schema :
 _
 door 1 | | door 2
 door 3 |_| door 4

 *************/

public class VehiclesTest {

    private Vehicles vehicles;

    @Before
    public void initVehicles() {
        /**
         VEHICLE_ID:VEHICLE_CATEGORY:FUEL_TYPE
         **/
        vehicles = new Vehicles("v1:CAR:Hybrid, v2:CAR:Hybrid, v3:TRUCK:Diesel, v4:MOTORCYCLE:Gasoline");
    }

    @Test
    public void aCarWithClosedDoorsCanMove() {
        vehicles.move("v1", "200 KM");
        Assert.assertEquals("The Car consumed 6.00 L", vehicles.consumption("v1"));
        Assert.assertEquals("Destination reached.", vehicles.status("v1"));
    }

    @Test
    public void aTruckWithClosedDoorsCanMove() {
        vehicles.move("v3", "1000 KM");
        Assert.assertEquals("The Truck consumed 50.00 L", vehicles.consumption("v3"));
        Assert.assertEquals("Destination reached.", vehicles.status("v3"));
    }

    @Test
    public void aTruckWithClosedDoorsCanAlwaysMove() {
        vehicles.move("v4", "50 KM");
        Assert.assertEquals("The Motorcycle will consume 3.00 L", vehicles.consumption("v4"));
        Assert.assertEquals("Destination reached.", vehicles.status("v4"));
    }

    @Test
    public void aCarWithFrontRightDoorOpenCannotMove() {

        /***********
         The car with door 2 open is displayed as below :
         _
         door 1  | \  door 2
         door 3  |_|  door 4

         ************/

        vehicles.openDoor("v2", "2");
        vehicles.move("v2", "200 KM");
        Assert.assertEquals("The Car will consume 0.00 L", vehicles.consumption("v2"));
        String expected = "All doors must be closed\n"+
                "  _\n"+
                " | \\\n"+
                " |_|";
        Assert.assertEquals(expected, vehicles.status("v2"));
    }

    @Test
    public void aCarWithBackLeftDoorOpenCannotMove() {

        /***********
         The car with door 3 open is displayed as below :
         _
         door 1  | |  door 2
         door 3  /_|  door 4

         ************/

        vehicles.openDoor("v2", "3");
        vehicles.move("v2", "200 KM");
        Assert.assertEquals("The Car will consume 0.00 L", vehicles.consumption("v2"));
        String expected = "All doors must be closed\n"+
                "  _\n"+
                " | |\n"+
                " /_|";
        Assert.assertEquals(expected, vehicles.status("v2"));
    }

}
