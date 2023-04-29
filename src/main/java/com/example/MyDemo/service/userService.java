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
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    public User updateUserById( User user) {
        return userRepository.save(user);
    }
    public void deleteUser(String userId) {
         userRepository.deleteById(userId);
    }

    public List<User> getUserByAddress(String address) {
        return userRepository.findAllByAddress(address);
    }


    public User getUserById(String userId) {
       return userRepository.findById(userId).get();
    }
}
