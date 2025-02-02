package com.example.ERP_SYSTEM.Controller;



import com.example.ERP_SYSTEM.Repo.UserRepo;
import com.example.ERP_SYSTEM.entities.Users.User_erp;
import com.example.ERP_SYSTEM.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserHtmlController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo repo;

    @GetMapping
    public String getAllUsers(Model model) {
        List<User_erp> users = repo.findAll();
        model.addAttribute("users", users);
        return "user-list"; // Verknüpft mit user-list.html in src/main/resources/templates/
    }

    @GetMapping("/create/{id}")
    public String showCreateForm(Model model,@PathVariable Integer id) {
        User_erp user = repo.findById(id).orElse(null);
        model.addAttribute("user", user);
        return "user-form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User_erp user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.findByID(id));
        return "user-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
