package com.example.ERP_SYSTEM.entities.Projekt;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "firstname" , nullable = false )
    private String firstname;
    @Column(name = "lastname" , nullable = false )
    private String lastname;
    @Column(name = "email" , nullable = false )
    private String email;
    @Column(name = "phoneNumber" , nullable = false )
    private String phoneNumber;
    @Column(name = "address" , nullable = false )
    private String address;
    @OneToMany
    @JoinColumn(name = "employee_id",columnDefinition = "id")
    private List<Task> tasks;



}
