package com.example.ERP_SYSTEM.Services;


import com.example.ERP_SYSTEM.Repo.RoleRepo;
import com.example.ERP_SYSTEM.entities.Users.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    RoleRepo roleRepo;


    public RoleService(RoleRepo roleRepository) {
        this.roleRepo = roleRepository;
    }

    // Alle Rollen abrufen
    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }

    // Rolle anhand der ID abrufen
    public Optional<Role> getRoleById(Integer id) {
        return roleRepo.findById(id);
    }

    // Rolle erstellen
    public Role createRole(Role role) {
        return roleRepo.save(role);
    }

    // Rolle aktualisieren
    public Role updateRole(Integer id, Role roleDetails) {
        if (roleRepo.existsById(id)) {
            roleDetails.setId(id); // Stellen Sie sicher, dass die ID beibehalten wird
            return roleRepo.save(roleDetails);
        }
        return null; // oder werfen Sie eine Ausnahme, wenn die Rolle nicht gefunden wurde
    }

    // Rolle löschen
    public void deleteRole(Integer id) {
        roleRepo.deleteById(id);
    }

    // Rolle nach Name suchen
    public Role getRoleByName(String name) {
        return roleRepo.findbyName(name); // Eine benutzerdefinierte Methode im Repository
    }
}
