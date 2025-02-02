package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.Users.User_erp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<User_erp, Integer > {
      Optional<User_erp> findByUsername(String username);
      Optional<User_erp> findByid(Integer id);

}
