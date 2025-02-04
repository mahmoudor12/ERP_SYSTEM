package com.example.ERP_SYSTEM.Controller;


import com.example.ERP_SYSTEM.Repo.ContactRepo;
import com.example.ERP_SYSTEM.entities.Kundenmanagment.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {


    @Autowired
    private final ContactRepo repo;

    public ContactController(ContactRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/all")
    public  String  getallContact(Model model){

        List<Contact> contacts = repo.findAll();
        model.addAttribute("contacts",contacts);
        return "contact-show";
    }
    @GetMapping("/new")
    public  String  getallContactnew(Model model){

        //List<Contact> contacts = repo.findAll();
        model.addAttribute("contact",new Contact());
        return "contact-form";
    }



}
