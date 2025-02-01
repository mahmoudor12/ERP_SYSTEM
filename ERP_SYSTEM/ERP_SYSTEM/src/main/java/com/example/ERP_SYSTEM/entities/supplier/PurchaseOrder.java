package com.example.ERP_SYSTEM.entities.supplier;

import com.example.ERP_SYSTEM.entities.Projekt.Employee;
import jakarta.persistence.*;

import java.time.LocalDate;

public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private Supplier supplier;  // Der Lieferant, der diese Bestellung gemacht hat

    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;  // Bestelldatum

    @Column(name = "amount", nullable = false)
    private Double amount;  // Bestellwert
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    public PurchaseOrder(Supplier supplier, LocalDate orderDate, Double amount, Employee employee) {
        this.supplier = supplier;
        this.orderDate = orderDate;
        this.amount = amount;
        this.employee = employee;
    }

    public PurchaseOrder() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
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

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "id=" + id +
                ", supplier=" + supplier +
                ", orderDate=" + orderDate +
                ", amount=" + amount +
                ", employee=" + employee +
                '}';
    }
}
