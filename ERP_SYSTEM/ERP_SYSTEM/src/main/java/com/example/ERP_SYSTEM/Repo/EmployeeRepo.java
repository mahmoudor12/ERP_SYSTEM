package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.Projekt.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {


}
