package com.kk.daemon;

public class DaemonThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello world! ");
        }
    }

    public static void main(String[] args) {
        DaemonThread DaemonThread = new DaemonThread();
        DaemonThread.setDaemon(true); // DaemonThread is daemon thread ( like Garbage collector ) now
        DaemonThread t1 = new DaemonThread();
        t1.start(); // t1 is user thread
        DaemonThread.start();
        System.out.println("Main Done");
    }
}
