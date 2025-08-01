package kh.edu.net.service.impl;

import kh.edu.net.dto.CustomerResponse;
import kh.edu.net.model.Customer;
import kh.edu.net.repository.CustomerRepository;
import kh.edu.net.service.CustomerService;

import java.util.List;

public abstract class CustomerServiceImpl implements CustomerService {
//    1.define object
    private final CustomerRepository customerRepository;

//    2.Inject object
    public CustomerServiceImpl(){
        customerRepository = new CustomerRepository();
    }

    @Override
    public List<CustomerResponse> getAllCustomers(){
//      All customers
        List<Customer> customers = customerRepository.getCustomerData();

//        Domain model => DTO
//        List<CustomerResponse> customerResponseList =
//        customers.stream().map(
//                (customer -> new CustomerResponse(
//                        customer.getFullName(),
//                        customer.getGender(),
//                        customer.getEmail()
//                ))
//        ).toList();
//        return customerResponseList;

        return customers.stream().map(
                (customer -> new CustomerResponse(
                        customer.getFullName(),
                        customer.getGender(),
                        customer.getEmail()
                ))
        ).toList();
    }

    @Override
    public CustomerResponse findCustomerByEmail(String email){
        //logic
        List<Customer> customers = customerRepository.getCustomerData();
        Customer foundCustomer =  customers.stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Customer not found"));
        //Map data
        CustomerResponse customerResponse = new CustomerResponse(
                foundCustomer.getFullName(),
                foundCustomer.getGender(),
                foundCustomer.getEmail()
        );
        return customerResponse;
    }
    @Override
    public CustomerResponse findCustomerById(int id){
        //logic
        List<Customer> customers = customerRepository.getCustomerData();
        Customer foundCustomer =  customers.stream()
                .filter(customer -> customer.getEmail().equals(id))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Customer not found"));
        //Map data
        CustomerResponse customerResponse = new CustomerResponse(
                foundCustomer.getFullName(),
                foundCustomer.getGender(),
                foundCustomer.getEmail()
        );
        return customerResponse;
    }
}

