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
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCustomer(){
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @GetMapping("/getByUsername/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username){
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }
    @GetMapping("/getBySearch/{stringSearch}")
    public ResponseEntity<?> getBySearch(@PathVariable String stringSearch){
        return ResponseEntity.ok(userService.getBySearch(stringSearch));
    }
    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user){
        userService.setUser(user);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        userService.setUser(user);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity.ok(null);
    }
}
