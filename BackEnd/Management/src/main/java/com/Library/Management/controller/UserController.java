package com.library.management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.management.entity.UsersEntity;
import com.library.management.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    //CREATE
    @PostMapping
    public UsersEntity createUser(@RequestBody UsersEntity user){
        return userService.saveUser(user);
    }

    //READ ALL
    @GetMapping
    public List<UsersEntity> getallUsers(){
        return userService.getAllUsers();
    }

    //READ BY ID
    @GetMapping("/{id}")
    public UsersEntity getUserById(@PathVariable int id){
        return userService.getUserById(id)
            .orElseThrow(()-> new RuntimeException("User Not Found!!"));
    }

    //UPDATE USER
    @PutMapping("/{id}")
    public UsersEntity updateUser(@PathVariable int id, @RequestBody UsersEntity user){
        return userService.updateUser(id, user);
    }
}
