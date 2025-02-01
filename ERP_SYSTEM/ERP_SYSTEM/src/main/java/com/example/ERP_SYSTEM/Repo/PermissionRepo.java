package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.Users.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepo extends JpaRepository<Permission,Integer> {
    Permission findByName(String name);
}
