package com.example.ERP_SYSTEM.Controller;

import com.example.ERP_SYSTEM.Repo.RegisterRepo;
import com.example.ERP_SYSTEM.entities.Users.Register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/register")
public class registerController {

    @Autowired
    private RegisterRepo repoReg;

    // Anzeige des Registrierungsformulars (ohne ID, für neue Benutzer)
    @GetMapping("/{id}")
    public String showRegistrationForm(Model model,@PathVariable Integer id) {

        Register register = repoReg.findById(id).orElse(null);
        model.addAttribute("register",register); // Leeres User-Objekt für das Formular
        return "register"; // HTML-Template für das Formular
    }
    @GetMapping("/show")
    public String showRegistration(Model model) {

        //Register register = repoReg.findById(id).orElse(null);
        model.addAttribute("register",new Register()); // Leeres User-Objekt für das Formular
        return "register-show"; // HTML-Template für das Formular
    }
    @GetMapping("/all")
    public String showRegistrations(Model model) {

        List<Register> registers = repoReg.findAll();
        model.addAttribute("registers",registers); // Leeres User-Objekt für das Formular
        return "register-list"; // HTML-Template für das Formular
    }
    // Registrierung des Benutzers (POST)
    @PostMapping("/save")
    public String registerUser(@ModelAttribute Register user) {
        try {
            repoReg.save(user);
             // Erfolgsseite nach der Registrierung
        } catch (IllegalStateException e) {

             // Wenn Fehler, Formular erneut anzeigen
        }
        return "redirect:/register/all";
    }

    // Erfolgsseite nach erfolgreicher Registrierung
    @GetMapping("/success")
    public String registrationSuccess() {
        return "success"; // Erfolgs-HTML-Seite
    }
}
