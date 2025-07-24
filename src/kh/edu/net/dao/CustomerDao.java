package kh.edu.net.dao;

import kh.edu.net.model.Customer;

import java.util.List;

public interface CustomerDao {
//    create customer
    void addCustomer(Customer customer);

//    return type
    List<Customer> getAllCustomer ();
}
