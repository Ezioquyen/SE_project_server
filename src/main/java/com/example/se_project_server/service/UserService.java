package com.example.se_project_server.service;

import com.example.se_project_server.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> getUserByUsername(String username);
    void setUser(User user);
    void deleteUser(Integer id);
    List<User> getAllUsers();

    List<User> getBySearch(String stringSearch);
}
