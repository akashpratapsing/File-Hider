package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class MyConnection {

    public static Connection connection;
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc?useSSL=false", "root", "1@mAkash");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Connection ho gya.....");
        return connection;
    }

    public static void close(){
        if (connection != null){
            try {
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        System.out.println("Connection Closed...");
    }

}
