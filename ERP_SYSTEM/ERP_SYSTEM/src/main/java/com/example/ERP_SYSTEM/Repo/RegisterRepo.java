package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.Users.Register;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegisterRepo extends JpaRepository<Register,Integer> {

     Optional<Register> findByname(String name);
}
