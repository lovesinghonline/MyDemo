package com.example.MyDemo.service;

import com.example.MyDemo.model.User;
import com.example.MyDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service


public class userService {
    @Autowired
    private UserRepository userRepository;
     public User getUser(){
      return userRepository.getUser();
    }

    public User saveUser(User user) {
         return userRepository.saveUser(user);
    }



    public User getUserById(int userId) {
         return userRepository.getUserById(userId);
    }

    public List<User> getAllUser() {
         return userRepository.getAllUser();
    }

    public User updateUserById(int userId, User user) {
         return userRepository.updateUserById(userId,user);
    }

    public User deleteUser(int userId) {
         return userRepository.deleteUser(userId);
    }
}
