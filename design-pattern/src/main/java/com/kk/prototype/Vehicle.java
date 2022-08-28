package com.kk.prototype;

import java.util.ArrayList;
import java.util.List;

public class Vehicle implements Cloneable {

    private List<String> vehicleList;

    public Vehicle() {
        this.vehicleList = new ArrayList<>();
    }

    public Vehicle(List<String> list) {
        this.vehicleList = list;
    }

    public List<String> getVehicleList() {
        return this.vehicleList;
    }

    public void insertData() {
        vehicleList.add("AUDI");
        vehicleList.add("BMW");
        vehicleList.add("TATA");
    }

    @Override
    public Object clone() {
        List<String> list = new ArrayList<>(this.vehicleList);
        return new Vehicle(list);
    }
}
