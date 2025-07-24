package kh.edu.net.dao.impl;

import kh.edu.net.dao.CustomerDao;
import kh.edu.net.model.Customer;

import java.util.List;
import java.util.UUID;

public class CustomerDaoImpl implements CustomerDao {
    private final Customer customer;
    private List<Customer> customerlist;

    public CustomerDaoImpl(Customer customer) {
        this.customer = customer;
        Customer customer = new Customer();

        customer.setId(UUID.randomUUID());
        customer.setFullName("Sreynet");
        customer.setGender("F");
        customer.setEmail("sreynet24@gmail.com");
        customer.setPhone("04387645");
        customer.setDeleted(false);

    }

    @Override
    public void addCustomer(Customer customer) {
//        perform logic
    }
    @Override
    public List<Customer> getAllCustomer(){
        return null;
    }

}
