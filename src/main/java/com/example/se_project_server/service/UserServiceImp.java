package com.example.se_project_server.service;

import com.example.se_project_server.entity.User;
import com.example.se_project_server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean addUser(User user) {
        if(userRepository.existsById(user.getId())){
            return false;
        }else{
            userRepository.save(user);
            return true;
        }
    }

    @Override
    public boolean updateUser(User user) {
        if(userRepository.existsById(user.getId())){
            userRepository.saveAndFlush(user);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteUserById(int id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
