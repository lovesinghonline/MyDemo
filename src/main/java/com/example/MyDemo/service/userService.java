package com.example.MyDemo.service;

import com.example.MyDemo.model.User;
import com.example.MyDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


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
}
