package com.example.ERP_SYSTEM.Services;

import com.example.ERP_SYSTEM.Repo.SupplierRepo;
import com.example.ERP_SYSTEM.entities.supplier.Supplier;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

     @Autowired
    SupplierRepo supplierRepo;
     public  void createSupplier(Supplier supplier){
         if (supplierRepo.existsById(supplier.getId())){

         }else {
             throw new EntityNotFoundException("Supplier with id:"+supplier.getId()+"schon vorhandeln");
         }
     }

     public Supplier getSupplier(Integer id){
         return supplierRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Supplier with id:"+id+"nicht vorhandeln"));
     }
     public List<Supplier> getall() {
         return supplierRepo.findAll();
     }

     public void delete(Integer id){
         if (supplierRepo.existsById(id)){
                supplierRepo.deleteById(id);

         }else { throw  new EntityNotFoundException("Supplier with id:"+id+" nicht vorhandeln");}
     }
     public  void update(Integer id , Supplier supplier){
           if (supplierRepo.existsById(id)){
               Supplier supplier1 = supplierRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Supplier with id:"+id+" nicht vorhandeln"));
               supplier1.setEmployee(supplier.getEmployee());
               supplier1.setAmount(supplier.getAmount());
               supplier1.setOrderDate(supplier.getOrderDate());

               supplierRepo.save(supplier1);
           }

     }

}
