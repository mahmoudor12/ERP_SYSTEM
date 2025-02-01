package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.Finanz.transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo  extends JpaRepository<transaction,Integer> {
        transaction findbyName(String name);
}
