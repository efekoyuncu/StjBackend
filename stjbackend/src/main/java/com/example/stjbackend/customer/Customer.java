package com.example.stjbackend.customer;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", password='" + password+ '\'' +
                ", email=" + email +
                '}';
    }


}
