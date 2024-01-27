package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        CustomerService customerService = new CustomerService();

        int customerId = 5;
        double initialBalance = 0;
        customerService.registerCustomer(customerId, initialBalance);
        System.out.println("Klient zarejestrowany.");


        double depositAmount = 600.0;
        TransactionResponse depositResponse = customerService.deposit(customerId, depositAmount);
        System.out.println("Nowe saldo: " + depositResponse.getNewBalance());


        Customer customer = customerService.getCustomer(customerId);
        if (customer != null) {
            System.out.println("Dane klienta: ID - " + customerId + ", Saldo - " + customer.getBalance());
        } else {
            System.out.println("Klient nie został znaleziony.");
        }
    }
}
