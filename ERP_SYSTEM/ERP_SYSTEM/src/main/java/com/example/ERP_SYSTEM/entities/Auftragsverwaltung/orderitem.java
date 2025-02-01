package com.example.ERP_SYSTEM.entities.Auftragsverwaltung;


import jakarta.persistence.*;

@Entity
@Table(name = "orderItem")
public class orderitem {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   @Column(name = "productName", length = 255, nullable = false)
   private String productName;
   @Column(name = "quantity", nullable = false)
   private  Integer quantity;
   @Column(name = "price", nullable = false)
   private  Double price;
   @Column(name="Totalpreis")
   private  Double Totalprice;
   @ManyToOne
   @JoinColumn(name ="order_id", columnDefinition ="id")
   private  Order order;

    public orderitem() {
    }

    public orderitem(String productName, Integer quantity, Double price, Double totalprice, Order order) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        Totalprice = totalprice;
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalprice() {
        return Totalprice;
    }

    public void setTotalprice(Double totalprice) {
        Totalprice = totalprice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "orderitem{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", Totalprice=" + Totalprice +
                ", order=" + order +
                '}';
    }
}
