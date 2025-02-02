package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.Produkte.Produkt;
import com.example.ERP_SYSTEM.entities.Projekt.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjektRepo  extends JpaRepository<Project,Integer>{
    }
