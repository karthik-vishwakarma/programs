package com.kk.structural.proxy;


interface DatabaseExecuter {
    void executeDatabase(String query);
}

class DatabaseExecuterImpl implements DatabaseExecuter {
    @Override
    public void executeDatabase(String query) {
        System.out.println("Going to execute query : " + query);
    }
}

class DatabaseExecuterProxy implements DatabaseExecuter {
    private boolean ifAdmin;
    private DatabaseExecuterImpl dbExecuter;

    public DatabaseExecuterProxy(String userName, String password) {
        if ("ADMIN" == userName && password == "ADMIN123") {
            ifAdmin = true;
        }
        dbExecuter = new DatabaseExecuterImpl();
    }

    @Override
    public void executeDatabase(String query) {
        if (ifAdmin) {
            dbExecuter.executeDatabase(query);
        } else {
            if (query == "DELETE") {
                System.out.println("DELETE OPERATION NOT ALLOWED");
            } else {
                dbExecuter.executeDatabase(query);
            }
        }
    }
}

public class ProxyPattern {
    public static void main(String[] args) {
        DatabaseExecuterProxy proxy1 = new DatabaseExecuterProxy("NON_ADMIN", "123");
        proxy1.executeDatabase("CREATE");
        proxy1.executeDatabase("DELETE");

        DatabaseExecuterProxy proxy2 = new DatabaseExecuterProxy("ADMIN", "ADMIN123");
        proxy2.executeDatabase("DELETE");
    }
}
