package com.sproject.crud.springboot.controller;
import com.sproject.crud.springboot.model.User;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    private Map<Long, User> userMap = new HashMap<>();
    private long currentId = 1;

    @GetMapping("/")
    public List<User> getAllUsers(){
        return new ArrayList<>(userMap.values());
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userMap.get(id);
    }

    @PostMapping("/")
    public User createUser(@Valid  @RequestBody User user){
        user.setId(currentId++);
        userMap.put(user.getId(),user);
        return user;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @Valid @RequestBody User user){
        user.setId(id);
        userMap.put(id, user);
        return user;
    }

    @DeleteMapping("/{id}")
    public  String deleteuser(@PathVariable Long id,@Valid @RequestBody User user){
        user.setId(id);
        userMap.remove(id);
        return "User is deleted";
    }

    @PatchMapping("/{id}")
    public User partialUpdateUser(@PathVariable Long id,@Valid @RequestBody Map<String, Object> updates) {
        User user = userMap.get(id);
        if (user != null) {
            updates.forEach((key, value) -> {
                if (key.equals("name")) user.setName((String) value);
                if (key.equals("email")) user.setEmail((String) value);
            });
        }
        return user;
    }
}
