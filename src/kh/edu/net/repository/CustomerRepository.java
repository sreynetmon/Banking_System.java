package kh.edu.net.repository;
import kh.edu.net.Database.DataConnection;
import kh.edu.net.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//get data from database
public class CustomerRepository {

//build in memory data of customer
 //   public List<Customer> getCustomerData(){
//        List<Customer> customerList = new ArrayList<>();
//        Customer customer1 = new Customer();
//        Customer customer2 = new Customer();
//        customer1.setId(1);
//        customer1.setFullName("Sreynet");
//        customer1.setGender("F");
//        customer1.setEmail("sreynet24@gmail.com");
//        customer1.setPhone("087537655");
//        customer1.setDeleted(false);
//        customer2.setId(2);
//        customer2.setFullName("Mana");
//        customer2.setGender("F");
//        customer2.setEmail("nana4@gmail.com");
//        customer2.setPhone("087274653");
//        customer2.setDeleted(false);
//        customerList.add(customer1);
//        customerList.add(customer2);
 //   }

    public List<Customer> getCustomerData(){
        String sql = """
                SELECT * FROM customers WHERE is_deleted = FALSE
                """;
        List<Customer> customerList = new ArrayList<>();

        try(
                Connection con = DataConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet result = ps.executeQuery(sql) // Added to try-with-resources
        ){
            // Process the ResultSet
            while(result.next()) {
                Customer customer = new Customer(
                        result.getInt("id"),
                        result.getString("full_name"),
                        result.getString("gender"),
                        result.getString("email"),
                        result.getBoolean("is_deleted")
                );
                customerList.add(customer);
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        }

        return customerList;
    }

    public boolean addCustomer(Customer customer) {
        String sql = "INSERT INTO customers (full_name,gender, email, phone_number, is_deleted) VALUES (?, ?,?, ?, false)";

        try (Connection conn = DataConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, customer.getFullName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPhone());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("❌ Failed to add customer: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteCustomerById(int id) {
        String sql = "UPDATE customers SET is_deleted = true WHERE id = ?";

        try (Connection conn = DataConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int affected = ps.executeUpdate();
            return affected > 0;

        } catch (SQLException e) {
            System.out.println("❌ Failed to delete customer: " + e.getMessage());
            return false;
        }
    }

    public boolean updateCustomer(Customer customer) {
        String sql = "UPDATE customers SET full_name = ?, email = ?, phone_number = ? WHERE id = ? AND is_deleted = FALSE";

        try (Connection conn = DataConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, customer.getFullName());
            pstmt.setString(2, customer.getEmail());
            pstmt.setString(3, customer.getPhone());
            pstmt.setInt(4, customer.getId());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("❌ Failed to update customer: " + e.getMessage());
            return false;
        }
    }

    public Customer getCustomerById(int id) {
        String sql = "SELECT * FROM customers WHERE id = ? AND is_deleted = FALSE";

        try (Connection conn = DataConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            while(result.next()) {
                Customer customer = new Customer(
                        result.getInt("id"),
                        result.getString("full_name"),
                        result.getString("email"),
                        result.getString("phone_number"),
                        result.getBoolean("is_deleted")
                );
            }

        } catch (SQLException e) {
            System.out.println("❌ Error getting customer by ID: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }


    public List<Customer> searchCustomerByIdOrEmail(Integer id, String email) {
        List<Customer> customers = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM customers WHERE is_deleted = FALSE");

        boolean hasId = id != null && id > 0;
        boolean hasEmail = email != null && !email.trim().isEmpty();

        if (!hasId && !hasEmail) {
            return customers; // empty list if no search criteria
        }

        if (hasId) {
            sql.append(" AND id = ?");
        }
        if (hasEmail) {
            sql.append(hasId ? " AND" : " AND");
            sql.append(" email LIKE ?");
        }

        try (Connection conn = DataConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {

            int paramIndex = 1;
            if (hasId) {
                ps.setInt(paramIndex++, id);
            }
            if (hasEmail) {
                ps.setString(paramIndex++, "%" + email + "%"); // partial match with LIKE
            }

            ResultSet result = ps.executeQuery();
            while(result.next()) {
                Customer customer = new Customer(
                        result.getInt("id"),
                        result.getString("full_name"),
                        result.getString("email"),
                        result.getString("phone_number"),
                        result.getBoolean("is_deleted")
                );
            }
        } catch (SQLException e) {
            System.out.println("❌ Failed to search customers: " + e.getMessage());
        }

        return customers;
    }
}
