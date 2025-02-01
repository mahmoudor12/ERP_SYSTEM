package com.example.ERP_SYSTEM.Services;

import com.example.ERP_SYSTEM.Repo.AccountRepo;
import com.example.ERP_SYSTEM.Repo.ContactRepo;
import com.example.ERP_SYSTEM.entities.Kundenmanagment.Contact;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

     @Autowired
     private ContactRepo contactRepo;


     public void createContact( Contact contact){
         if (contactRepo.existsById(contact.getId())){
              contactRepo.save(contact);

         }else {
               throw new EntityNotFoundException("Contact with ID:"+contact.getId()+"vorhandeln");

         }}
     public Contact getContact(Integer id){
            return  contactRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Contact with ID:"+id+"nicht vorhandeln"));

     }
     public List<Contact> getAll(){

          return contactRepo.findAll();
     }

     public void delete(Integer id){
         if (contactRepo.existsById(id)){
             contactRepo.deleteById(id);
         }else {
             throw new EntityNotFoundException("Contact with Id:"+ id + "nicht vorhandeln");
         }

     }
     public void update(Integer id , Contact contact ){
            if (contactRepo.existsById(id)){
               Contact contact1  =contactRepo.findById(id).orElse(null);
               contact1.setPosition(contact.getPosition());
               contact1.setDepartment(contact.getDepartment());
               contact1.setEmail(contact.getEmail());
               contact1.setFirstname(contact.getFirstname());
               contact1.setLastname(contact.getLastname());
               contact1.setCustomersList(contact.getCustomersList());
                contactRepo.save(contact1);
            }else
            {
                throw new EntityNotFoundException("Contact with Id:"+ id + "nicht vorhandeln");
            }

     }


}
