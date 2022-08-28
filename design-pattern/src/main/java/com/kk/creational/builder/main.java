package com.kk.creational.builder;

public class main {
    public static void main(String[] args) {
        Vehicle car = new Vehicle.VehicleBuilder("1500CC", "W4").setAirbags(2).build();
        System.out.println(car.getAirbags());
        System.out.println(car.getEngine());
        System.out.println(car.getWheel());
        Vehicle bike = new Vehicle.VehicleBuilder("100CC", "W2").build();
        System.out.println(bike.getAirbags());
        System.out.println(bike.getEngine());
        System.out.println(bike.getWheel());
    }
}
