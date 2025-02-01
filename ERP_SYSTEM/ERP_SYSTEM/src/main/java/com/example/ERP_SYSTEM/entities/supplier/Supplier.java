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
}
