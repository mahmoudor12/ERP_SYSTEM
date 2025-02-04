package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.Auftragsverwaltung.orderitem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<orderitem,Integer> {

}
