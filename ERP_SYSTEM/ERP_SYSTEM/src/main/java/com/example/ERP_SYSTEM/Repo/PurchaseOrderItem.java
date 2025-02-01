package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.supplier.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderItem extends JpaRepository<PurchaseOrderItem, Integer>{
   PurchaseOrder findByName(String name);
}

