package com.example.energymanagement.service;

import com.example.energymanagement.model.domain.Customer;
import com.example.energymanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer login(String email, String password) {
        Customer customer = customerRepository.getCustomerByEmail(email);
        if (customer != null && password.equals(customer.getPassword())) {
            return customer;
        }
        return null;
    }

    public Customer register(String name, String password, String email, String billingAddress, String phone) {
        if (customerRepository.getCustomerByEmail(email) != null) {
            return null;
        }

        Customer customer = new Customer();
        customer.setName(name);
        customer.setPassword(password);
        customer.setEmail(email);
        customer.setBillingAddress(billingAddress);
        customer.setPhone(phone);
        customerRepository.insertCustomer(customer);
        return customer;
    }

    public Customer findByEmail(String email) {
        return customerRepository.getCustomerByEmail(email);
    }

}
