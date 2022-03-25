package com.datngo.customer.service;

import com.datngo.customer.model.CustomerRequest;
import com.datngo.customer.entity.Customer;
import com.datngo.customer.model.FraudCheckResponse;
import com.datngo.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void register(CustomerRequest customerRequest) throws IllegalAccessException {
        Customer customer = Customer.builder()
                                    .firstName(customerRequest.getFirstName())
                                    .lastName(customerRequest.getLastName())
                                    .email(customerRequest.getEmail())
                                    .build();

        customerRepository.saveAndFlush(customer);
        // check is fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        if (fraudCheckResponse.isFraudulentCustomer()) {
            throw new IllegalAccessException("fraudster");
        }
    }
}
