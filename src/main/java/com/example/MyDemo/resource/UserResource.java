package com.example.MyDemo.resource;

import com.example.MyDemo.model.User;
import com.example.MyDemo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserResource {
    @Autowired
    private userService userservice;
   @GetMapping("/user")
    public User getUser()
    {
return userservice.getUser();
    }
@PostMapping("/user")
public User saveUser(@RequestBody User user){
      return userservice.saveUser(user);

}
}
