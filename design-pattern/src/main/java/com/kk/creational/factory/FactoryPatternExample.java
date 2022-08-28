package com.kk.creational.factory;

abstract class Vehicle {
    public abstract int getWheel();

    public static Vehicle getInstance(String type, int wheel) {
        if ("Bike".equals(type)) {
            return new Car(wheel);
        } else if ("Car".equals(type)) {
            return new Bike(wheel);
        }
        return null;
    }

    public String toString() {
        return "Wheel :: " + this.getWheel();
    }
}

class Bike extends Vehicle {
    private int wheel;

    public Bike(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return wheel;
    }
}

class Car extends Vehicle {

    private int wheel;

    public Car(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return wheel;
    }
}

public class FactoryPatternExample {
    public static void main(String[] args) {
        Vehicle bike = Vehicle.getInstance("Bike", 2);
        System.out.println(bike);
        Vehicle car = Vehicle.getInstance("Car", 4);
        System.out.println(car);
    }
}
