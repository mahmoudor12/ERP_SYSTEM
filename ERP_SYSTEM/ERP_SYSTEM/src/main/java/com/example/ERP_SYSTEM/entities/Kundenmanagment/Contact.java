package com.example.ERP_SYSTEM.entities.Kundenmanagment;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "firstname" , nullable = false )
    private  String firstname;
    @Column(name = "lastname" , nullable = false )
    private  String lastname;
    @Column(name = "email" , nullable = false )
    private  String email;
    @Column(name = "phonenumber" , nullable = false )
    private  String phonenumber;
    @Column(name = "position" , nullable = false )
    private  String position;
    @Column(name = "department" , nullable = false )
    private  String department;
    @OneToMany(mappedBy = "contact")
    private List<Customers> customersList = new ArrayList<>();

    public Contact(String firstname, String lastname, String email, String phonenumber, String position, String department, List<Customers> customersList) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.position = position;
        this.department = department;
        this.customersList = customersList;
    }

    public Contact() {
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Customers> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(List<Customers> customersList) {
        this.customersList = customersList;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", customersList=" + customersList +
                '}';
    }
}

