package com.example.se_project_server.service;

import com.example.se_project_server.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> findAllUser ();
    Optional<User> findUserById(int id);
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUserById(int id);
    List<User> getAllUsers();
}
