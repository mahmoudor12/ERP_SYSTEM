package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.Users.User_erp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User_erp, Integer > {
      User_erp findByname(String name);

}
