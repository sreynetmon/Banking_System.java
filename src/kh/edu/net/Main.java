package kh.edu.net;

import kh.edu.net.model.Customer;
import kh.edu.net.view.CustomerView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.time.chrono.JapaneseEra.values;

public class Main {
    public static void main(String[] args) {
//        CustomerView customerView = new CustomerView();
//        customerView.customerFeatures();

        Customer customer = new Customer(
//                1,
//                "Sreynet",
//                "Female"
//                "net2gmial.com",
//                "09584732",
//                false;

        );

        System.out.println("JDBC");
//        1. Add driver
//        2. Create connection
        String url = "jdbc:postgresql://localhost:5432/bankingsystem_db";
        String user = "postgres";
        String password = "240904";
        String sql = """
                insert into customers (id, full_name, email, phone_number, gender, is_deleted)
                values (?,?,?,?,?,?)
                """;

        try( Connection connection = DriverManager.getConnection(url,user,password)){
            PreparedStatement statement = connection.prepareStatement(sql);
//            PreparedStatement statement1 = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt("1"));
            statement.setString(2, "Net");
            statement.setString(3, "Female");
            statement.setString(4, "net@gmail.com");
            statement.setString(5, "090348575");
            statement.setBoolean(6, false);


            int rowUpdate = statement.executeUpdate();
            System.out.println(rowUpdate);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }

    }
}