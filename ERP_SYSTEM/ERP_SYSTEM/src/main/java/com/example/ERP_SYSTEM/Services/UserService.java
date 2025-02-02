package com.example.ERP_SYSTEM.Services;


import com.example.ERP_SYSTEM.Repo.UserRepo;
import com.example.ERP_SYSTEM.entities.Users.User_erp;
import jakarta.persistence.EntityNotFoundException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

      @Autowired
      UserRepo userRepo;
      public  User_erp findByID(Integer id){

          return  userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

      }
      public  User_erp createUser(User_erp userErp){
          User_erp userErp1 ;
          if (userRepo.existsById(userErp.getId())){
               userErp1= userRepo.save(userErp);
            }else {
                throw new EntityNotFoundException("User with ID"+userErp.getId()+"schon vorhandeln");
            }
        return  userErp1;
      }
      public User_erp getUser(Integer id){
             return userRepo.findById(id).orElseThrow(()->new EntityNotFoundException("User with ID"+id+"schon vorhandeln") );
      }
      public List<User_erp> getAll(){
          return userRepo.findAll();
      }

    public User_erp updateUser(Integer id, User_erp userDetails) {
        return userRepo.findById(id).map(user -> {
            user.setUsername(userDetails.getUsername());
            user.setPassword(userDetails.getPassword());
            return userRepo.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }
     public  void delete(Integer id){
          if (userRepo.existsById(id)){
              userRepo.deleteById(id);
          }else {
              throw new EntityNotFoundException("User with ID"+id+"schon vorhandeln");
          }
     }

}
