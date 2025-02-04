package com.example.ERP_SYSTEM.Controller;

import com.example.ERP_SYSTEM.Repo.CustomerRepo;
import com.example.ERP_SYSTEM.entities.Kundenmanagment.Customers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {

       private final CustomerRepo customerRepo;

    public CompanyController(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @GetMapping("/all")
    public  String  getCompany(Model model){
        List<Customers>customers = customerRepo.findAll();
        model.addAttribute("companies",customers);
        return "customer-show";
    }
    @GetMapping("/new")
    public  String  getCompanynew(Model model){
        //List<Customers>customers = customerRepo.findAll();
        model.addAttribute("company",new Customers());
        return "company-form";
    }

}
