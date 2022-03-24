package com.datngo.customer.service;

import com.datngo.customer.dto.CustomerRequest;
import com.datngo.customer.entity.Customer;
import com.datngo.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void register(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                                    .firstName(customerRequest.getFirstName())
                                    .lastName(customerRequest.getLastName())
                                    .email(customerRequest.getEmail())
                                    .build();
        customerRepository.save(customer);
    }
}
