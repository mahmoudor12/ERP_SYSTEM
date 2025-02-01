package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.supplier.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderItem extends JpaRepository<PurchaseOrderItem, Integer>{
   PurchaseOrder findByName(String name);
}

