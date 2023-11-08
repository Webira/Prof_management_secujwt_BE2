package com.web.usersmanagement.controller;
import com.web.usersmanagement.exception.UserNotFoundException;
import com.web.usersmanagement.model.User;
import com.web.usersmanagement.repository.UserRepository;
import com.web.usersmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/user")
    User newUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    List<User>getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @PutMapping("/user/update/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id){
        return userService.updateUser(id, newUser);
    }
    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
