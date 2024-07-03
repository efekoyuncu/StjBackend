package com.example.stjbackend.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        Customer registeredCustomer = customerService.registerCustomer(customer);
        return new ResponseEntity<>(registeredCustomer, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginCustomer(@RequestBody Customer customer) {
        String token = customerService.loginCustomer(customer.getUsername(), customer.getPassword());
        return ResponseEntity.ok(token);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }
}
