package com.kk.prototype;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.insertData();

        System.out.println(vehicle.getVehicleList());

        Vehicle clone = (Vehicle) vehicle.clone();
        List<String> vehicleList = vehicle.getVehicleList();
        System.out.println(vehicleList);
        vehicleList.add("HONDA");
        System.out.println(vehicleList);
    }
}
