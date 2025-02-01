package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.Users.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Integer> {
    Role findbyName(String name);
}
