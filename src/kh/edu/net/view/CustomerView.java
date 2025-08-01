package kh.edu.net.view;

import kh.edu.net.controller.CustomerController;
import kh.edu.net.dto.CustomerResponse;
import kh.edu.net.model.Customer;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class CustomerView {
    private final CustomerController customerController;
    public CustomerView(){
        customerController = new CustomerController();
    }

    public void customerFeatures(){
//        Customer Menu
        System.out.println("=".repeat(30));
        System.out.println("[1] View All Customers");
        System.out.println("[2] Search Customer by Email");
        System.out.println("[3] Search Customer by ID");
        System.out.println("=".repeat(30));

        System.out.print("Enter Option: ");
        int option = new Scanner(System.in).nextInt();
        switch (option){
            case 1 -> {
                List<CustomerResponse> allCustomer = customerController.getAllCustomers();
                //render view
                allCustomer.forEach(System.out::println);
            }
            case 2 -> {
                System.out.print("Enter email: ");
                String email = new Scanner(System.in).nextLine();
                try{
                    CustomerResponse customer = customerController.findCustomerByEmail(email);
                    System.out.println(customer);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
            case 3 -> {
                System.out.print("Enter ID: ");
                int id = new Scanner(System.in).nextInt();
                try{
                    CustomerResponse customerId = customerController.findCustomerByID(id);
                    System.out.println(customerId);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
