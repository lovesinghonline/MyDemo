package com.example.MyDemo.repository;

import com.example.MyDemo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {

    List<User> findAllByAddress(String address);
}
