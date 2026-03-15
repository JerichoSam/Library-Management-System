package com.library.management.controller;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.management.entity.AuthRequest;
import com.library.management.entity.UsersEntity;
import com.library.management.service.JwtService;
import com.library.management.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/Welcome")
    public String welcome(){    
            return "Welcome this endpoint is not secure";
    }
    
    //CREATE
    @PostMapping
    public UsersEntity createUser(@RequestBody UsersEntity user){
        return userService.saveUser(user);
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        if( authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());
        }else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
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
