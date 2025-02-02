package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.Stocks.stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepo extends JpaRepository<stock,Integer> {


}
