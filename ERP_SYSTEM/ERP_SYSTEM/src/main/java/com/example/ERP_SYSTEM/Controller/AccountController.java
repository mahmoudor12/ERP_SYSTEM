package com.example.ERP_SYSTEM.Controller;

import com.example.ERP_SYSTEM.Repo.AccountRepo;
import com.example.ERP_SYSTEM.entities.Finanz.account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {


              @Autowired
              AccountRepo accountRepo;
              @GetMapping("/all")
              public String getAccounts(Model model){
                  List<account> accountList = accountRepo.findAll();
                  model.addAttribute("accounts",accountList);
                  return "account-show";
              }
       /*
        @GetMapping("/{id}")
        public String getAccounts(@PathVariable Integer id, Model model){
        account account = accountRepo.findById(id).orElse(null);
        model.addAttribute("accounts",account);
        return "account";
        }*/
        @PostMapping("/save")
       public String PostAccount(@ModelAttribute account acco){
                  if(acco !=null){
                      accountRepo.save(acco);
                  }else {

                  }
                  return "redirect:/account/all"; }


        @GetMapping("/new")
       public String CreateAccount(Model model){
                  model.addAttribute("account",new account());
                  return "account-details";
       }

}
