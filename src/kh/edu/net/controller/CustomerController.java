package kh.edu.net.controller;

import kh.edu.net.dao.CustomerDao;
import kh.edu.net.dao.impl.CustomerDaoImpl;

public class CustomerController {

//
    private final CustomerDao customerDao;
    public Object getCustomer;

    public CustomerController(){
        customerDao = new CustomerDaoImpl();
    }
}
