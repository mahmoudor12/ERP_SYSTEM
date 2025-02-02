package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.Finanz.transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo  extends JpaRepository<transaction,Integer> {

}
