package com.example.app_customers.service;

import com.example.app_customers.model.Customer;
import com.example.app_customers.model.Group;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();
    void saveCustomer(Customer customer);
    Customer getCustomerById(long id);
    void deleteCustomerById(long id);

}
