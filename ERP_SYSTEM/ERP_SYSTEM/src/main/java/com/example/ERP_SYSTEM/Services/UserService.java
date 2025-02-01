package com.example.ERP_SYSTEM.Services;


import com.example.ERP_SYSTEM.Repo.UserRepo;
import com.example.ERP_SYSTEM.entities.Users.User_erp;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

      @Autowired
      UserRepo userRepo;

      public  void createUser(User_erp userErp){
            if (userRepo.existsById(userErp.getId())){
                userRepo.save(userErp);
            }else {
                throw new EntityNotFoundException("User with ID"+userErp.getId()+"schon vorhandeln");
            }}
      public User_erp getUser(Integer id){
             return userRepo.findById(id).orElseThrow(()->new EntityNotFoundException("User with ID"+id+"schon vorhandeln") );
      }
      public List<User_erp> getAll(){
          return userRepo.findAll();
      }

      public void update(Integer id, User_erp user2){
            if (userRepo.existsById(id)){
                User_erp user1 = userRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("User with ID"+id+"schon vorhandeln"));
                 user1.setUsername(user2.getUsername());
                 user1.setEmail(user2.getEmail());
                 user1.setPassword(user2.getPassword());
                 user1.setEnable(user2.isEnable());
                 user1.setRoleList(user2.getRoleList());
                 userRepo.save(user1);
            } }
     public  void delete(Integer id){
          if (userRepo.existsById(id)){
              userRepo.deleteById(id);
          }else {
              throw new EntityNotFoundException("User with ID"+id+"schon vorhandeln");
          }
     }

}
