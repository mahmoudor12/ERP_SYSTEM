package com.example.ERP_SYSTEM.Repo;

import com.example.ERP_SYSTEM.entities.Kundenmanagment.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact,Integer> {
    Contact findByName(String name);
    Contact findByEmail(String email);

}
