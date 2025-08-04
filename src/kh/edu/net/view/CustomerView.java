package kh.edu.net.view;

import kh.edu.net.controller.CustomerController;
import kh.edu.net.dto.CustomerResponse;
import kh.edu.net.model.Customer;
import kh.edu.net.repository.CustomerRepository;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class CustomerView {
    Scanner scanner = new Scanner(System.in);
    private final CustomerController customerController;
    public CustomerView(){
        customerController = new CustomerController();
    }
    private final CustomerRepository cusRepo = new CustomerRepository();

    public void customerFeatures(){
//        Customer Menu
            while (true) {
                try {
                    System.out.println("\n📋 Customer Menu:");
                    System.out.println("1. Show all customers");
                    System.out.println("2. Add customer");
                    System.out.println("3. Delete customer by ID");
                    System.out.println("4. Update customer by ID");
                    System.out.println("5. Search customer by ID or Email");
                    System.out.println("0. Exit");
                    System.out.print("Enter choice: ");

                    int choice = Integer.parseInt(scanner.nextLine());

                    switch (choice) {
                        case 1 -> showAll();
                        case 2 -> addCustomer();
                        case 3 -> deleteCustomer();
                        case 4 -> updateCustomer();
                        case 5 -> searchCustomer();
                        case 0 -> {
                            System.out.println("👋 Goodbye!");
                            return;
                        }
                        default -> System.out.println("❌ Invalid choice!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ Please enter a valid number.");
                } catch (Exception e) {
                    System.out.println("⚠️ Unexpected error: " + e.getMessage());
                }
            }
        }

//        ShowAll
    private void showAll() {
        List<Customer> customers = cusRepo.getCustomerData();
        if (customers.isEmpty()) {
            System.out.println("⚠️ No customers found.");
            return;
        }

        System.out.println("\n📄 Customer List:");
        for (Customer c : customers) {
            System.out.printf("ID: %d, Name: %s, Email: %s, Phone: %s%n",
                    c.getId(), c.getFullName(), c.getEmail(), c.getPhone());
        }
    }

    //Add customer
    private void addCustomer() {
        try {
//            System.out.print("ID: ");
//            int id = scanner.nextInt();
            System.out.print("Full Name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Gender: ");
            String gender = scanner.nextLine().trim();
            System.out.print("Email: ");
            String email = scanner.nextLine().trim();
            System.out.print("Phone Number: ");
            String phone = scanner.nextLine().trim();


            if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                System.out.println("⚠️ All fields are required.");
                return;
            }

            Customer customer = new Customer(0, name, email, phone, false);
            cusRepo.addCustomer(customer);
            System.out.println("✅ Customer added successfully.");
        } catch (Exception e) {
            System.out.println("⚠️ Failed to add customer: " + e.getMessage());
        }
    }

    //delete
    private void deleteCustomer() {
        try {
            System.out.print("Enter Customer ID to delete: ");
            int id = Integer.parseInt(scanner.nextLine());
            boolean success = cusRepo.deleteCustomerById(id);

            if (success) {
                System.out.println("✅ Customer deleted successfully.");
            } else {
                System.out.println("❌ Customer not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("⚠️ Please enter a valid ID.");
        } catch (Exception e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }
    }

    //update
    private void updateCustomer() {
        try {
            System.out.print("Enter Customer ID to update: ");
            int id = Integer.parseInt(scanner.nextLine());

            Customer existingCustomer = cusRepo.getCustomerById(id);
            if (existingCustomer == null) {
                System.out.println("❌ Customer not found!");
                return;
            }

            System.out.println("Leave field empty to keep current value.");
            System.out.print("Full Name [" + existingCustomer.getFullName() + "]: ");
            String name = scanner.nextLine();
            System.out.print("Email [" + existingCustomer.getEmail() + "]: ");
            String email = scanner.nextLine();
            System.out.print("Phone Number [" + existingCustomer.getPhone() + "]: ");
            String phone = scanner.nextLine();

            if (!name.isBlank()) existingCustomer.setFullName(name);
            if (!email.isBlank()) existingCustomer.setEmail(email);
            if (!phone.isBlank()) existingCustomer.setPhone(phone);

            cusRepo.updateCustomer(existingCustomer);
            System.out.println("✅ Customer updated successfully.");
        } catch (NumberFormatException e) {
            System.out.println("⚠️ Invalid ID format.");
        } catch (Exception e) {
            System.out.println("⚠️ Error while updating: " + e.getMessage());
        }
    }

    //search
    private void searchCustomer() {
        try {
            System.out.print("Enter Customer ID to search: ");
            String idInput = scanner.nextLine().trim();

            if (idInput.isEmpty()) {
                System.out.println("⚠️ ID is required to search.");
                return;
            }

            Integer id = null;
            try {
                id = Integer.parseInt(idInput);
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid ID format.");
                return;
            }

            Customer customer = cusRepo.getCustomerById(id);

            if (customer == null) {
                System.out.println("⚠️ No customer found with ID " + id);
                return;
            }

            System.out.println("\n📄 Customer Details:");
            System.out.printf("ID: %d, Name: %s, Email: %s, Phone: %s, DOB: %s%n",
                    customer.getId(), customer.getFullName(), customer.getEmail(),
                    customer.getPhone());

        } catch (Exception e) {
            System.out.println("⚠️ Error during search: " + e.getMessage());
        }
    }

}
