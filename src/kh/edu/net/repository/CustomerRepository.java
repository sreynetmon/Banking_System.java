package kh.edu.net.repository;

import kh.edu.net.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//get data from database
public class CustomerRepository {

//build in memory data of customer
    public List<Customer> getCustomerData(){
        List<Customer> customerList = new ArrayList<>();
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();

        customer1.setId(UUID.randomUUID());
        customer1.setFullName("Sreynet");
        customer1.setGender("F");
        customer1.setEmail("sreynet24@gmail.com");
        customer1.setPhone("087537655");
        customer1.setDeleted(false);

        customer2.setId(UUID.randomUUID());
        customer2.setFullName("Mana");
        customer2.setGender("F");
        customer2.setEmail("nana4@gmail.com");
        customer2.setPhone("087274653");
        customer2.setDeleted(false);

        customerList.add(customer1);
        customerList.add(customer2);

        return customerList;
    }
}
