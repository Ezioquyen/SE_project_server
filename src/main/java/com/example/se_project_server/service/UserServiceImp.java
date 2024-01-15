package com.example.se_project_server.service;

import com.example.se_project_server.entity.User;
import com.example.se_project_server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;


    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getBySearch(String stringSearch) {
        return userRepository.getBySearch(stringSearch);
    }



    @Override
    public List<User> getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public void setUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
