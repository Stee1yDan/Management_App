package com.management.employemanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class Employee implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;
    private String name;
    private String email;
    private String occupation;
    private String phoneNumber;
    private String imageURL;
    @Column(nullable = false, updatable = false)
    private String employeeCode;

    public Employee(String name, String email, String occupation, String phoneNumber, String imageURL)
    {
        this.name = name;
        this.email = email;
        this.occupation = occupation;
        this.phoneNumber = phoneNumber;
        this.imageURL = imageURL;
    }
}
