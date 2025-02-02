package com.example.ERP_SYSTEM.Repo;


import com.example.ERP_SYSTEM.entities.Finanz.account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<account,Integer> {
           }

