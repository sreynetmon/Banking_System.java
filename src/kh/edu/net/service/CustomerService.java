package kh.edu.net.service;

import kh.edu.net.dto.CustomerResponse;

import java.util.List;

public interface CustomerService {
//    get all customer - return type as arrayList
     List<CustomerResponse> getAllCustomers();

//     return type, name of method, parameter
    CustomerResponse findCustomerByEmail(String email);


    CustomerResponse findCustomerByID(int id);

    CustomerResponse findCustomerById(int id);
}
