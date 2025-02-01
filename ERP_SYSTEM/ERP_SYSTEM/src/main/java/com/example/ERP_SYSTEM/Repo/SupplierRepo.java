package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.supplier.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepo extends JpaRepository<Supplier,Integer> {
     Supplier findByname(String name);
}
