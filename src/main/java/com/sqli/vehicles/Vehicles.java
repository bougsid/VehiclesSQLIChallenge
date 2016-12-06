package com.sqli.vehicles;

import com.sqli.fuel.FuelFactory;
import com.sqli.fuel.FuelStrategy;
import com.sqli.vehicle.Motorcycle;
import com.sqli.vehicle.Vehicle;
import com.sqli.vehicle.VehicleFactory;

import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

import static com.sqli.configuration.Configuration.DETAILS_SEPARATOR;
import static com.sqli.configuration.Configuration.VEHICLE_SEPARATOR;

/************
 The aim of the exercise is to pass all the test cases bellow.
 It's about vehicles and their consumption. Each vehicle has a different consumption according to its Fuel type :
 - Diesel: 5%
 - Gasoline: 6%
 - Hybrid: 3%

 There are three categories of vehicles : 
 * CAR has 4 vehicle.getDoors()
 * TRUCK has 2 vehicle.getDoors()
 * MOTORCYCLE has no vehicle.getDoors()

 A vehicle with 4 vehicle.getDoors() is displayed as bellow. Please respect the door's numbers as in the schema :
 _
 door 1 | | door 2
 door 3 |_| door 4

 *************/

public class Vehicles {


    private Map<String, Vehicle> vehicleMap = new HashMap<>();

    public Vehicles(String vehicleDescriptions) {
        if (!isBlank(vehicleDescriptions)) {
            String vehicles[] = vehicleDescriptions.split(VEHICLE_SEPARATOR);
            for (String v : vehicles) {
                String vehicleDetails[] = v.split(DETAILS_SEPARATOR);
                Vehicle vehicle = null;
                String id = "";
                FuelStrategy fuel = null;
                //Get vehicle id
                if (vehicleDetails.length > 0 && !isBlank(vehicleDetails[0])) {
                    id = vehicleDetails[0];
                }
                //Get vehicle fuel
                if (vehicleDetails.length > 2 && !isBlank(vehicleDetails[2])) {
                    fuel = FuelFactory.getFuel(vehicleDetails[2]);
                }
                //Get Vehicle Instance
                if (vehicleDetails.length > 1 && !isBlank(vehicleDetails[1])) {
                    vehicle = VehicleFactory.getVehicle(vehicleDetails[1]);
                    assert vehicle != null;
                    vehicle.setId(id);
                    vehicle.setFuel(fuel);
                }
                this.vehicleMap.put(id.trim(), vehicle);
            }
        }
    }

    void move(String vehicleId, String distance) {
        Vehicle vehicle = vehicleMap.get(vehicleId);
        if (vehicle != null) {
            double dist = Double.valueOf(distance.substring(0, distance.length() - 2).trim());
            //Set consumption if all doors are closed or if the vehicle is Motorcycle
            if (vehicle.isAllDoorsClosed() || vehicle instanceof Motorcycle)
                vehicle.setConsumption(vehicle.getFuel().getConsumption() * dist);
        }
    }

    String status(String vehicleId) {
        Vehicle vehicle = vehicleMap.get(vehicleId);
        //The Destination reached if all doors are closed or if the vehicle is Motorcycle
        if (vehicle.isAllDoorsClosed() || vehicle instanceof Motorcycle)
            return "Destination reached.";
        else {
            return "All doors must be closed\n" + this.designVehicle(vehicle);
        }
    }

    String consumption(String vehicleId) {
        Vehicle vehicle = vehicleMap.get(vehicleId);
        return "The "
                + getType(vehicle)
                + ((!vehicle.isAllDoorsClosed()) ? " will consume " : " consumed ")
                + new Formatter().format("%.2f", vehicle.getConsumption()).toString().replace(",", ".")
                + " L";
    }

    void openDoor(String vehicleId, String doorNumber) {
        Vehicle vehicle = vehicleMap.get(vehicleId);
        vehicle.openDoor(Integer.parseInt(doorNumber));
    }

    //Build the design of the Vehicle
    private String designVehicle(Vehicle vehicle) {
        //Check  if the is Motorcycle (has no design because it has no doors)
        if (vehicle instanceof Motorcycle) return "";
        StringBuilder design = new StringBuilder("");
        int doors = vehicle.getDoorsStatus().length;
        design.append("  _\n");
        for (int i = 0; i < doors; i++) {
            boolean pair = ((i + 1) % 2 == 0);
            if (vehicle.getDoorsStatus()[i] && pair) {
                design.append("\\");
                if (i + 1 != doors) {
                    design.append("\n");
                }
            } else if (vehicle.getDoorsStatus()[i] && !pair) {
                if (i == (doors - 2)) {
                    design.append(" /_");
                } else {
                    design.append(" / ");
                }
            } else if (!vehicle.getDoorsStatus()[i] && pair) {
                design.append("|");
                if (i + 1 != doors) {
                    design.append("\n");
                }
            } else if (!vehicle.getDoorsStatus()[i] && !pair) {
                if (i == (doors - 2)) {
                    design.append(" |_");
                } else {
                    design.append(" | ");
                }
            }
        }
        return design.toString();
    }

    //Check if CharSequence is blank
    private static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    //Get Vehicle name = the same as the class name
    private String getType(Vehicle vehicle) {
        return vehicle.getClass().getName().substring(vehicle.getClass().getName().lastIndexOf(".") + 1);
    }
}
