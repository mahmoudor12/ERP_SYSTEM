package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.supplier.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SupplierRepo extends JpaRepository<Supplier,Integer> {

}
