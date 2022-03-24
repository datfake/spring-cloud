package com.datngo.customer.controller;

import com.datngo.customer.dto.CustomerRequest;
import com.datngo.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRequest customerRequest) {
        log.info("Register successfully customer {}", customerRequest);
        customerService.register(customerRequest);
    }
}
