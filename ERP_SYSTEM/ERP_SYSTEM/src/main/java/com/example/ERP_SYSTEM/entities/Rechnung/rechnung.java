package com.example.ERP_SYSTEM.entities.Rechnung;

import com.example.ERP_SYSTEM.entities.Auftragsverwaltung.Order;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="invoice")
public class rechnung {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "order_id" ,columnDefinition = "id")
    private Order order;
    @Column(name = "invoice_Date")
    private LocalDate invoiceDate;
    @Column(name = "dueDate")
    private LocalDate dueDate;
    @Column(name = "totalAmount")
    private double totalAmount;
    @Column(name = "status")
    private String status;

    public rechnung() {
    }

    public rechnung(Order order, LocalDate invoiceDate, LocalDate dueDate, double totalAmount, String status) {
        this.order = order;
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "rechnung{" +
                "id=" + id +
                ", order=" + order +
                ", invoiceDate=" + invoiceDate +
                ", dueDate=" + dueDate +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                '}';
    }
}
