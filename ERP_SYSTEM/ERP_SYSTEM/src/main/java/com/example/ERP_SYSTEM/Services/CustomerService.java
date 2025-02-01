package com.example.ERP_SYSTEM.Services;

import com.example.ERP_SYSTEM.Repo.CustomerRepo;
import com.example.ERP_SYSTEM.entities.Kundenmanagment.Customers;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
     @Autowired
     CustomerRepo customerRepo;

    private  void createCustomer(Customers customers){
        if (customerRepo.existsById(customers.getId())){
            customerRepo.save(customers);

        }else {
            throw new EntityNotFoundException("Customer with ID"+customers.getId()+"schon vorhandeln");
        }
    }
    private Customers getCustomers(Integer id){

        return customerRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Customer with ID"+id+"nicht vorhandeln"));
    }

    private List<Customers> getAll(){

        return customerRepo.findAll();}

    private void delete(Integer id){
        if (customerRepo.existsById(id)){
            customerRepo.deleteById(id);
        }else{
            throw new EntityNotFoundException("Customer with ID"+id+"nicht vorhandeln");
        }
    }
   private void update(Integer id , Customers customers ){
          if (customerRepo.existsById(id)){
              Customers customers1 = customerRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Customer with ID" +id+ "nicht vorhandeln"));
                customers1.setCustomerType(customers.getCustomerType());
                customers1.setAddress(customers.getAddress());
                customers1.setContact(customers.getContact());
                customers1.setUpdatedAt(customers.getUpdatedAt());
                customers1.setEmail(customers.getEmail());
                customers1.setCreatedAt(customers.getCreatedAt());
                customers1.setCompanyName(customers.getCompanyName());
                customers1.setPhoneNumber(customers.getPhoneNumber());
                customerRepo.save(customers1);
          }else{
              throw new EntityNotFoundException("Customer with ID"+id+"nicht vorhandeln");
          }}
}
