package com.kk;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ApplicationRunner {
    public static void main(String[] args) {
        System.out.println("*****Application Start***********");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        System.out.println(sessionFactory);
    }
}