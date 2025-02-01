package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.Finanz.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentRepo extends JpaRepository<Payment,Integer> {
     Payment findbyName(String name);
}
