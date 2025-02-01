package com.example.ERP_SYSTEM.Services;

import com.example.ERP_SYSTEM.Repo.StockRepo;
import com.example.ERP_SYSTEM.entities.Stocks.stock;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Stock {
    @Autowired
    StockRepo stockRepo;

    public void createStock(stock stock){
        if (stockRepo.existsById(stock.getId())){
            stockRepo.save(stock);

        }else{
            throw new EntityNotFoundException("Stock with ID:"+stock.getId()+ " schon vorhandeln");
        }
    }
   public stock getStock(Integer id){
        return  stockRepo.findById(id).orElseThrow(()->
                new EntityNotFoundException("Stock with ID:"+id+ " nicht vorhandeln"));
   }
   public List<stock> getAll(){
        return stockRepo.findAll();
   }

   public void delete(Integer id){
        if (stockRepo.existsById(id)){
              stockRepo.deleteById(id);

        } else{
            throw new EntityNotFoundException("Stock with ID:"+id+ " nicht vorhandeln");
        }
   }

  public void update(Integer id, stock stock){
        if (stockRepo.existsById(id)){
         stock stock1  = stockRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Stock with ID:"+ id + " nicht vorhandeln"));
           stock1.setDescription(stock.getDescription());
           stock1.setStatus(stock.getStatus());
           stock1.setEmployee(stock.getEmployee());
           stock1.setProject(stock.getProject());
           stock1.setDueDate(stock.getDueDate());
           stock1.setTaskName(stock.getTaskName());
           stockRepo.save(stock1);
        }
  }
}
