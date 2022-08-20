package com.kk;

import java.sql.*;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/TEST", "root", "root");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from designation");

        while (resultSet.next()){

            System.out.print(resultSet.getInt("code"));
            System.out.println(" :: " +resultSet.getString("title"));
        }
        resultSet.close();
        statement.close();
        connection.close();

        System.out.println("---------------");
    }
}