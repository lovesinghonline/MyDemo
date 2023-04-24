package com.example.MyDemo.resource;

import com.example.MyDemo.model.User;
import com.example.MyDemo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/allUser")
    public List<User> getAllUser(){
       return userservice.getAllUser();
    }
    @PutMapping("/user/{userId}")
    public User updateUserById(@PathVariable("userId") int userId,@RequestBody User user){
        return userservice. updateUserById(userId,user);
    }
@PostMapping("/user")
public User saveUser(@RequestBody User user){
      return userservice.saveUser(user);

}
@GetMapping("/user/{userId}")
public User getUserById( @PathVariable("userId") int userId)
{return userservice. getUserById(userId);
}
@DeleteMapping("/user")
    public User deleteUser(@RequestParam( name = "userId") int userId){
       return userservice.deleteUser(userId);
}

}
