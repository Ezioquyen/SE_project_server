package com.example.se_project_server.controller;

import com.example.se_project_server.entity.Staff;
import com.example.se_project_server.entity.User;
import com.example.se_project_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/find-all")
    public List<User> findAllUser(){
        return userService.findAllUser();
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCustomer(){
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @GetMapping("/find/{id}")
    public Optional<User> findById(@PathVariable int id){
        return userService.findUserById(id);
    }

    @PostMapping("/add-user")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUserById(id);
    }
}
