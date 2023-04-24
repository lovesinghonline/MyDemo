package com.example.MyDemo.repository;

import com.example.MyDemo.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public List<User> userList= new ArrayList<>();
    public User getUser(){
       User user =new User("love","canada",28);
        return user;
    }

    public User saveUser(User user) {


       user.setUserId(userList.size()+1);
        userList.add(user);
        return user;
    }



    public User getUserById(int userId) {
         for (User user:userList)
         {
             if(user.getUserId()==userId){
                 return user;
             }
         }


        return null;
    }

    public List<User> getAllUser() {
        return userList;
    }

    public User updateUserById(int userId, User user) {
        for (User u:userList)
        {
            if(u.getUserId()==userId){
                u.setName(user.getName());
                u.setAge(user.getAge());
                u.setAddress(user.getAddress());
                return user;
            }
    }
return null;
    }

    public User deleteUser(int userId) {
        User deleteuser= null;
        for (User u:userList)
        {
            if(u.getUserId()==userId){
                deleteuser=u;
                userList.remove(u);
                return deleteuser;
            }

        }
    return null;
    }
}

