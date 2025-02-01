package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.Rechnung.rechnung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RechnungRepo extends JpaRepository<rechnung,Integer> {
     rechnung findByname(String name);
}


