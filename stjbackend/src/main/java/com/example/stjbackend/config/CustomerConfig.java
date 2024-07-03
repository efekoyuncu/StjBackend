package com.example.stjbackend.config;

import com.example.stjbackend.customer.Customer;
import com.example.stjbackend.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Autowired
    private CustomerRepository customerRepository;

    @Bean
    CommandLineRunner initDatabase(CustomerRepository customerRepository) {
        return args -> {
            Customer customer = new Customer();
            customer.setUsername("testuser");
            customer.setPassword("$2a$10$Dow1JbOJ1Zk4dq2fXGixR.sE0l5A2M8OR5uK8dUmJ35PjyYpUO2qS"); // bcrypt encoded password for 'testpass'
            customer.setEmail("testuser@example.com");
            customerRepository.save(customer);
        };
    }
}
