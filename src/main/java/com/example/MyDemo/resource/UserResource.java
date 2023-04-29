package com.example.MyDemo.resource;

import com.example.MyDemo.exception.RestrictedIfoException;
import com.example.MyDemo.model.User;
import com.example.MyDemo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/users")
public class UserResource {
    @Autowired
    private userService userservice;
    @PostMapping
    public User saveUser(@RequestBody @Valid User user){
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
    public List<User> getUserByAddress(@RequestParam(name ="Address") String address) throws RestrictedIfoException {
        if(address.equalsIgnoreCase("area51"))
        {
            throw new RestrictedIfoException();
        }
        return userservice. getUserByAddress(address);
    }

    @GetMapping("/fiindbyId")
    public User getUserId(@RequestParam(name="userId") String userId)
    {
        return userservice.getUserById(userId);
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
