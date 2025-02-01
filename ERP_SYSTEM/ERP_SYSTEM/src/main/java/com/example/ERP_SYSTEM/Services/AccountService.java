package com.example.ERP_SYSTEM.Services;


import com.example.ERP_SYSTEM.Repo.AccountRepo;
import com.example.ERP_SYSTEM.entities.Finanz.account;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
      @Autowired
      private AccountRepo accountrepo;

      public void createAccount(account account){
          if(!accountrepo.existsById(account.getId())){
                accountrepo.save(account);

          }else {
              throw new EntityNotFoundException("Account with ID  " +account.getId()+" schon vorhandeln");
          }
      }

      public account getAccount(Integer id){

          return accountrepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Account With ID" +id+ "nicht vorhandeln")); }
      public List<account> getAll(){

          return accountrepo.findAll();
      }
      public void deletAccount( Integer id){
          if (accountrepo.existsById(id)){
              accountrepo.deleteById(id);

          }else {
              throw new EntityNotFoundException("Account with ID" +id+ "nicht vorhandeln");
          }
      }
      public void update(Integer id , account account){
             if (accountrepo.existsById(id)){
                 account account1 = accountrepo.findById(id).orElse(null );
                 account1.setAccountHolder(account.getAccountHolder());
                 account1.setAccountNumber(account.getAccountNumber());
                 account1.setAccountType(account.getAccountType());
                 account1.setBalance(account.getBalance());
                 account1.setCurrency(account.getCurrency());
                 account1.setIban(account.getIban());
                 accountrepo.save(account1);
             }else {

                   throw  new EntityNotFoundException("Account with ID"+id+" nicht vorhandeln");
             }

      }
}
