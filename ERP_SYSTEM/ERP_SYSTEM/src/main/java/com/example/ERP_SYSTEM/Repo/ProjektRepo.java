package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.Produkte.Produkt;
import com.example.ERP_SYSTEM.entities.Projekt.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjektRepo  extends JpaRepository<Produkt,Integer>{
     Project findbyName(String name); }
