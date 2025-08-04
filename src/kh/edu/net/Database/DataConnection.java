package kh.edu.net.Database;

import kh.edu.net.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Connection.*;

public class DataConnection {
    //singleton instance
    private static Connection connection;
    private static String URL = "jdbc:postgresql://localhost:5432/bankingsystem_db";
    private static String USER = "postgres";
    private static String PASSWORD = "240904";
    private DataConnection(){
//        private constructor to prevent instantiation
    }
    //    public static Connection getConnection;
    public static Connection getConnection(){
        try{
            if(connection == null || connection.isClosed()){
                connection = DriverManager.getConnection(URL,USER, PASSWORD);
            }
        }catch (SQLException e){
            System.out.println("Connection fail!");
        }
        return null;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
