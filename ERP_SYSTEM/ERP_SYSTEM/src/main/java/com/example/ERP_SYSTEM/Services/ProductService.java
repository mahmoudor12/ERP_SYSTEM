package com.example.ERP_SYSTEM.Services;


import com.example.ERP_SYSTEM.Repo.ProductRepo;
import com.example.ERP_SYSTEM.entities.Produkte.Produkt;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
      @Autowired
      ProductRepo productRepo;

     public  void createProduct(Produkt produkt){
         if (productRepo.existsById(produkt.getId())){
             productRepo.save(produkt);
         }else {
             throw new EntityNotFoundException("Produkt with ID  " +produkt.getId()+" schon vorhandeln");
         }
     }
     public Produkt getProdukt(Integer id){
         return productRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Produkt with ID  "+id+ " nicht vorhandeln"));
     }
     public List<Produkt> getAll(){
         return productRepo.findAll();
     }
     public  void delete(Integer id){
         if (productRepo.existsById(id)){
             productRepo.deleteById(id);
         }else {
             throw new EntityNotFoundException("Produkt with ID  "+id+ " nicht vorhandeln");
         }
     }

     public void update(Integer id, Produkt produkt){

         if(productRepo.existsById(id)){
               Produkt produkt1 = productRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Produkt with ID  "+ id + " nicht vorhandeln"));
               produkt1.setDescription(produkt.getDescription());
               produkt1.setDescription1(produkt.getDescription1());
               produkt1.setDescription2(produkt.getDescription2());
               produkt1.setDescription3(produkt.getDescription3());
               produkt1.setArtnr(produkt.getArtnr());
               produkt1.setImageUrl(produkt.getImageUrl());
               produkt1.setPrice(produkt.getPrice());
               produkt1.setPruduct_name(produkt.getPruduct_name());
               produkt1.setStockQuantity(produkt.getStockQuantity());
               produkt1.setWarehouse(produkt.getWarehouse());
               productRepo.save(produkt1);
         }else {

             throw new  EntityNotFoundException("Produkt with ID  "+ id + " nicht vorhandeln");
         }
     }


}
