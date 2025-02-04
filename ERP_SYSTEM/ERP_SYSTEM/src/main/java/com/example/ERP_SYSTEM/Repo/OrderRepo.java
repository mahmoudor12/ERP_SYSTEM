package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.Auftragsverwaltung.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Integer> {


}
