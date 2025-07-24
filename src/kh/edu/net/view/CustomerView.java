package kh.edu.net.view;

import kh.edu.net.controller.CustomerController;

import java.util.Scanner;

public class CustomerView {
    private final CustomerController customerController;

    public CustomerView() {
        customerController = new CustomerController();
    }

    public void customerFeature(){
//        1. get customer
        System.out.println("1. View Customer");;
        System.out.print("Enter Option: ");
        int option = new Scanner(System.in).nextInt();

        switch(option){
            case 1:{
                System.out.println("View Customer");
                customerController.getCustomer();
            }
            default:{
                System.out.println("Invalid");
            }
        }
    }
}
