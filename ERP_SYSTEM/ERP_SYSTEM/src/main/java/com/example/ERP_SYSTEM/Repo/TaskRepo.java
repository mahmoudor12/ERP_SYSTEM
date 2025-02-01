package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.Projekt.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo  extends JpaRepository<Task,Integer> {
       Task findByname(String name);
}
