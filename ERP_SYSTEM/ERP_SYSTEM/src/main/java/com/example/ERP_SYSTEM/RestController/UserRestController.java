package com.example.ERP_SYSTEM.RestController;



import com.example.ERP_SYSTEM.Repo.UserRepo;
import com.example.ERP_SYSTEM.entities.Users.User_erp;
import com.example.ERP_SYSTEM.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserService userService;
    @GetMapping
    public List<User_erp> getAllUsers() {
        return userRepo.findAll();
    }


        @GetMapping("/{id}")
        public ResponseEntity<User_erp> getUserById(@PathVariable Integer id) {
            Optional<User_erp> user = userRepo.findById(id);
            return user.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }


    @GetMapping("/username/{username}")
    public ResponseEntity<User_erp> getUserByUsername(@PathVariable String username) {
        Optional<User_erp> user = userRepo.findByUsername(username);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User_erp> createUser(@RequestBody User_erp user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User_erp> updateUser(@PathVariable Integer id, @RequestBody User_erp userDetails) {
        try {
            User_erp updatedUser = userService.updateUser(id, userDetails);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
