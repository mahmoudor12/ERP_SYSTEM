package com.example.ERP_SYSTEM.Services;


import com.example.ERP_SYSTEM.Repo.TransactionRepo;
import com.example.ERP_SYSTEM.entities.Finanz.transaction;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

         @Autowired
         TransactionRepo transactionRepo;

         public void createTransaction(transaction transaction){
             if (transactionRepo.existsById(transaction.getId())){
                 transactionRepo.save(transaction);
             }else {
                 throw new EntityNotFoundException("transaction with ID"+transaction.getId()+"schon vorhandeln");
             }
         }

         public  transaction createTransaction(Integer id){
             return transactionRepo.findById(id).orElseThrow(()->
                     new EntityNotFoundException("transaction with ID"+id+"nicht vorhandeln") );
         }
        public List<transaction> getall(){
             return transactionRepo.findAll();
        }

        public void delete(Integer id){
             if (transactionRepo.existsById(id)){
                 transactionRepo.deleteById(id);
             }else {
                 throw  new EntityNotFoundException("Transaction with ID:"+id+" nicht vorhandeln");

             }}
        public void update(Integer id, transaction transaction){
                if (transactionRepo.existsById(id)){

                     transaction transaction1 = transactionRepo.findById(id).orElseThrow(()->
                             new EntityNotFoundException("Transaction with ID:"+id+" nicht vorhandeln"));

                     transaction1.setTransactionDate(transaction.getTransactionDate());
                     transaction1.setAmount(transaction.getAmount());
                     transaction1.setStatus(transaction.getStatus());
                     transaction1.setCurrency(transaction.getCurrency());
                     transaction1.setPaymentMethod(transaction.getPaymentMethod());
                     transaction1.setSenderAccount(transaction.getSenderAccount());
                     transaction1.setReceiverAccount(transaction.getReceiverAccount());
                     transactionRepo.save(transaction1);
                }

        }

}
