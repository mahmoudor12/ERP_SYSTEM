package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.supplier.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderItemRepo extends JpaRepository<PurchaseOrder, Integer>{

}

