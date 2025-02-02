package com.example.ERP_SYSTEM.entities.Produkte;



import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "warehouse")

public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true, length = 255)
    private String name; // Name des Lagerhauses (z.B. "Lagerhaus A")

    @Column(name = "location", nullable = false, length = 255)
    private String location; // Standort des Lagerhauses (z.B. "Berlin, Deutschland")

    @Column(name = "capacity", nullable = true)
    private Integer capacity; // Kapazität des Lagerhauses (optional)

    // Eine Liste von Produkten, die in diesem Lagerhaus aufbewahrt werden
    @OneToMany(mappedBy = "warehouse")
    private List<Produkt> products;

    public Warehouse() {}

    public Warehouse(String name, String location, Integer capacity) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Produkt> getProducts() {
        return products;
    }

    public void setProducts(List<Produkt> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                ", products=" + products +
                '}';
    }
}


