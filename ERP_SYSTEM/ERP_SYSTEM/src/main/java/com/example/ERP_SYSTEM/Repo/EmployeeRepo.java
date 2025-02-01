package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.Projekt.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    Employee findByName(String name);
    Employee findByEmail(String email);

}
