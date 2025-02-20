package com.example.ERP_SYSTEM.entities.Auftragsverwaltung;


import com.example.ERP_SYSTEM.entities.supplier.Supplier;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;

     @Column(name = "order_number")
     private String orderNumber; // Eindeutige Bestellnummer
    @Column(name = "order_Date")
     private LocalDate orderDate;
    @Column(name = "order_status")
     private String status;
    @Column(name = "Order_shippingAdress")
     private String shippingAdress;
    @Column(name = "Order_totalAmount")
     private Double totalAmount;
     @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
     private List<orderitem> orderitemList = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private Supplier supplier;  // Der Lieferant, der diese Bestellung gemacht hat
    public Order(String orderNumber, LocalDate orderDate, String status,
                 String shippingAdress, Double totalAmount, List<orderitem> orderitemList, Supplier supplier) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.status = status;
        this.shippingAdress = shippingAdress;
        this.totalAmount = totalAmount;
        this.orderitemList = orderitemList;
        this.supplier = supplier;
    }

    public Order() {
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShippingAdress() {
        return shippingAdress;
    }

    public void setShippingAdress(String shippingAdress) {
        this.shippingAdress = shippingAdress;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<orderitem> getOrderitemList() {
        return orderitemList;
    }

    public void setOrderitemList(List<orderitem> orderitemList) {
        this.orderitemList = orderitemList;
    }
    public boolean check(Order order){
        return order != null;
    }
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", shippingAdress='" + shippingAdress + '\'' +
                ", totalAmount=" + totalAmount +
                ", orderitemList=" + orderitemList +
                '}';
    }
}
