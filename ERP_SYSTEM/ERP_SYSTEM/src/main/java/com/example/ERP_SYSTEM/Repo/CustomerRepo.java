package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.Kundenmanagment.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customers,Integer> {

}
