package com.kk.structural.observer;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

interface Subeject {
    void register(Observer obj);

    void unregister(Observer obj);

    void notifyObservers();
}

class DeliverData implements Subeject {
    private List<Observer> observers;
    private String location;

    public DeliverData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(location);
        }
    }

    public void updateLocation() {
        this.location = getLocation();
        notifyObservers();
    }

    private String getLocation() {
        return "L1" + UUID.randomUUID();
    }
}

interface Observer {
    void update(String location);
}

class Seller implements Observer {

    @Override
    public void update(String location) {
        System.out.println("Notification at Seller :: Location " + location);
    }
}

class User implements Observer {

    @Override
    public void update(String location) {
        System.out.println("Notification at User :: Location " + location);
    }
}

class WareHouse implements Observer {

    @Override
    public void update(String location) {
        System.out.println("Notification at WareHouse :: Location " + location);
    }
}

public class ObserverDesignPattern {
    public static void main(String[] args) {
        DeliverData deliverData = new DeliverData();
        deliverData.register(new Seller());
        deliverData.register(new WareHouse());
        Observer user = new User();
        deliverData.register(user);
        deliverData.updateLocation();

        deliverData.unregister(user);
        deliverData.updateLocation();
    }
}
