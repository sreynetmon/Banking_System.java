package kh.edu.net.controller;

import kh.edu.net.dto.CustomerResponse;
import kh.edu.net.model.Customer;
import kh.edu.net.service.CustomerService;
import kh.edu.net.service.impl.CustomerServiceImpl;

import java.util.List;

public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(){
        customerService = new CustomerServiceImpl();
    }

    public List<CustomerResponse> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    public CustomerResponse findCustomerByEmail (String email){
        return customerService.findCustomerByEmail(email);
    }
}
