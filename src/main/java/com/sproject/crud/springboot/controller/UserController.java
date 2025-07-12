package com.sproject.crud.springboot.controller;
import com.sproject.crud.springboot.model.User;
import com.sproject.crud.springboot.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    private Map<Long, User> userMap = new HashMap<>();
    private long currentId = 1;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public User createUser(@Valid @RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User>  updateUser(@PathVariable Long id, @Valid @RequestBody User userDetail){
        return userRepository.findById(id).map(user -> {
            userDetail.setName(user.getName());
            userDetail.setEmail(user.getEmail());
            User updatedUser = userRepository.save(user);
            return ResponseEntity.ok(updatedUser);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteUser(@PathVariable Long id){
        return userRepository.findById(id)
                .map(user ->{
                    userRepository.delete(user);
                    return ResponseEntity.ok("User is deleted");
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUserName(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User user = userOptional.get();

        if (updates.containsKey("name")) {
            user.setName((String) updates.get("name"));
        }

        // Add similar checks if updating more fields
        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

}
