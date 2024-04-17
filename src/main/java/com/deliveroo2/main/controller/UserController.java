package com.deliveroo2.main.controller;

import com.deliveroo2.main.model.User;
import com.deliveroo2.main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User user){
         User addedUser = userRepository.save(user);

         kafkaTemplate.send("prototypeevents", "User {" + addedUser.getId() + "} was created successfully")
                 .whenComplete((result, throwable) -> {
                     if(throwable == null){
                         System.out.println("Event Triggered Successfully");
                     } else {
                         throwable.printStackTrace();
                     }
                 });

         return ResponseEntity.ok("User {" + addedUser.getId() + "} was created successfully");
    }

    @GetMapping
    public Iterable<User> readAllUsers(){
        return userRepository.findAll();
    }
}
