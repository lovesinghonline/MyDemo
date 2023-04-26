package com.example.MyDemo.resource;

import com.example.MyDemo.model.User;
import com.example.MyDemo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResource {
    @Autowired
    private userService userservice;
    @PostMapping
    public User saveUser(@RequestBody User user){
        return userservice.saveUser(user);
    }
    @GetMapping
    public List<User> getAllUser(){
        return userservice.getAllUser();
    }
    @PutMapping("{userId}")
    public User updateUserById(@RequestBody User user){
        return userservice. updateUserById(user);
    }
    @DeleteMapping
    public void deleteUser(@RequestParam( name = "userId") String userId){
         userservice.deleteUser(userId);
    }
    @GetMapping("/find")
    public List<User> getUserByAddress(@RequestParam(name ="Address") String address)
    {return userservice. getUserByAddress(address);
    }
  /* @GetMapping("/user")
    public User getUser()
    {
return userservice.getUser();
    }

    @PutMapping("/user/{userId}")
    public User updateUserById(@PathVariable("userId") int userId,@RequestBody User user){
        return userservice. updateUserById(userId,user);
    }


@DeleteMapping("/user")
    public User deleteUser(@RequestParam( name = "userId") int userId){
       return userservice.deleteUser(userId);
}*/

}
