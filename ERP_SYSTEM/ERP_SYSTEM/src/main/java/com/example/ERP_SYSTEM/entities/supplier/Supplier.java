package com.example.ERP_SYSTEM.entities.supplier;


import com.example.ERP_SYSTEM.entities.Projekt.Employee;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;  // Bestelldatum

    @Column(name = "amount", nullable = false)
    private Double amount;  // Bestellwert
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Supplier(Supplier supplier, LocalDate orderDate, Double amount, Employee employee) {

        this.orderDate = orderDate;
        this.amount = amount;
        this.employee = employee;
    }

    public Supplier() {
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", amount=" + amount +
                ", employee=" + employee +
                '}';
    }
}
