package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.Kundenmanagment.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customers,Integer> {
    Customers findByName(String name);
    Customers findByEmail(String name);
}
