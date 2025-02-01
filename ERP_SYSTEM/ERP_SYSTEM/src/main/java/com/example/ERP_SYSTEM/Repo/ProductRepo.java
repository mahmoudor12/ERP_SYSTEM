package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.Produkte.Produkt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepo extends JpaRepository<Produkt,Integer> {
      Produkt findByName(String name); }
