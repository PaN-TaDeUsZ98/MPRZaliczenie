package org.example;

import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    private final Map<Integer, Customer> customerMap = new HashMap<>();

    public void registerCustomer(int id, double initialBalance) {
        customerMap.put(id, new Customer());
    }

    public TransactionResponse transfer(int customerId, double amount) {
        Customer customer = customerMap.get(customerId);
        if (customer == null || customer.getBalance() < amount) {
            return new TransactionResponse(TransactionStatus.DECLINED, 0);
        }
        customer.setBalance(customer.getBalance() - amount);
        return new TransactionResponse(TransactionStatus.ACCEPTED, customer.getBalance());
    }

    public TransactionResponse deposit(int customerId, double amount) {
        Customer customer = customerMap.get(customerId);
        if (customer == null) {
            return new TransactionResponse(TransactionStatus.DECLINED, 0);
        }
        customer.setBalance(customer.getBalance() + amount);
        return new TransactionResponse(TransactionStatus.ACCEPTED, customer.getBalance());
    }

    public Customer getCustomer(int customerId) {
        return customerMap.get(customerId);
    }
}