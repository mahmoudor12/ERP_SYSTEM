package com.example.ERP_SYSTEM.entities.Projekt;


import com.example.ERP_SYSTEM.entities.supplier.PurchaseOrder;
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
    @JoinColumn(name = "employee_id")
    private List<Task> tasks;

    @OneToMany(mappedBy = "employees", cascade = CascadeType.ALL)
    private List<PurchaseOrder> purchaseOrders;

    public Employee(Integer id, String firstname, String lastname, String email, String phoneNumber, String address, List<Task> tasks, List<PurchaseOrder> purchaseOrders) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.tasks = tasks;
        this.purchaseOrders = purchaseOrders;
    }

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", tasks=" + tasks +
                ", purchaseOrders=" + purchaseOrders +
                '}';
    }
}
