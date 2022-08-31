package com.kk.structural.bridge;


abstract class TV {
    Remote remote;

    TV(Remote remote) {
        this.remote = remote;
    }

    abstract void on();

    abstract void off();
}

class Sony extends TV {
    Remote r;

    Sony(Remote remote) {
        super(remote);
        this.r = remote;
    }

    @Override
    void on() {
        System.out.print("Sony TV On :: ");
        r.on();
    }

    @Override
    void off() {
        System.out.print("Sony TV OFF :: ");
        r.off();
    }
}

class Philips extends TV {
    Remote r;

    Philips(Remote remote) {
        super(remote);
        this.r = remote;
    }

    @Override
    void on() {
        System.out.print("Philips TV On :: ");
        r.on();
    }

    @Override
    void off() {
        System.out.print("Philips TV OFF :: ");
        r.off();
    }
}

interface Remote {
    void on();

    void off();
}

class NewRemote implements Remote {

    @Override
    public void on() {
        System.out.println("ON via new remote");
    }

    @Override
    public void off() {
        System.out.println("OFF via new remote");
    }
}

class OldRemote implements Remote {

    @Override
    public void on() {
        System.out.println("ON via old remote");
    }

    @Override
    public void off() {
        System.out.println("OFF via old remote");
    }
}

public class Client {
    public static void main(String[] args) {
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.off();
        sonyOldRemote.on();

        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.off();
        sonyNewRemote.on();


        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.off();
        philipsOldRemote.on();

        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.off();
        philipsNewRemote.on();
    }
}
