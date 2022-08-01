package com.example.halykb.controller;

import com.example.halykb.entity.Users;
import com.example.halykb.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller("/")
public class MainController {

    private UserRepo userRepo;

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/")
    public ResponseEntity getHome () {
        return ResponseEntity.ok("Welcome to HalykB project!!!");
    }


    @GetMapping(value = "get/UserByPerNum/{perNum}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserByPerNum(@PathVariable Long perNum) {
        if (perNum == 0) {
            return ResponseEntity.ok(userRepo.findAll());
        }

        Users user = userRepo.findByPerNum(perNum);
        if (user == null) {
            return ResponseEntity.ok("User does not exist!");
        }
        else {
            return ResponseEntity.ok(user);
        }
    }

    @PostMapping(value = "create/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addUser(@RequestBody Users user) {
        List<Users> users = userRepo.findAll();
        Optional<Users> optionalUser = users.stream().filter(u -> u.getPerNum().equals(user.getPerNum())).findFirst();
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok("ERROR: User with same perNum already exists!");
        }
        userRepo.save(user);
        return ResponseEntity.ok("User created successfully!");
    }
}
