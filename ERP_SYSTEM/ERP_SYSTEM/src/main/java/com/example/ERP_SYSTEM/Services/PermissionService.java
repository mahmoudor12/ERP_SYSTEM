package com.example.ERP_SYSTEM.Services;





import com.example.ERP_SYSTEM.entities.*;
import com.example.ERP_SYSTEM.Repo.PermissionRepo;
import com.example.ERP_SYSTEM.entities.Users.Permission;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {
    @Autowired
    private final PermissionRepo permissionRepository;


    public PermissionService(PermissionRepo permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public void savePermission(Permission permission)
    {
         if (permissionRepository.existsById(permission.getId())){
             permissionRepository.save(permission);
          }else {
             throw  new EntityNotFoundException("Permission with ID" + permission.getId() +"schon vorhandeln");
         }

    }

    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    public Permission getPermissionById(Integer id) {
        return permissionRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Permission with ID" + id +"schon vorhandeln"));
    }

    public Permission getPermissionByName(String name) {
        return permissionRepository.findByName(name);
    }

    public void deletePermission(Integer id) {
        permissionRepository.deleteById(id);
    }

    public void update(Integer id , Permission permission){
        if(permissionRepository.existsById(id)) {
            Permission permission1 = permissionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Permission with ID" + id + "schon vorhandeln"));

            permission1.setDescription(permission.getDescription());
            permission1.setName(permission.getName());
            permissionRepository.save(permission1);
        }}
}
