package com.example.MyDemo.repository;

import com.example.MyDemo.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    List<User> userList= new ArrayList();
    public User getUser(){
        User user =new User("love","canada",28);
        return user;
    }

    public User saveUser(User user) {

        boolean add = userList.add(user);
        return user;
    }
}

