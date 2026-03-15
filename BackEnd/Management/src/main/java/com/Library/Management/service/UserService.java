package com.library.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.library.management.entity.UsersEntity;
import com.library.management.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder encoder){
        this.userRepository = userRepository;
        this.encoder = encoder;
    }
    //CREATE
    public UsersEntity saveUser(UsersEntity usersEntity){
        return userRepository.save(usersEntity);
    }

    //READ ALL
    public List<UsersEntity> getAllUsers(){
        return userRepository.findAll();
    }

    // READ BY ID
    public Optional<UsersEntity> getUserById(int id){
        return userRepository.findById(id);
    }

    //UPDATE USER
    public UsersEntity updateUser(int id, UsersEntity updatedUsersEntity){
        return userRepository.findById(id)
            .map(userEntity -> {
                userEntity.setEmail(updatedUsersEntity.getEmail());
                userEntity.setCreatedAt(updatedUsersEntity.getCreatedAt());
                return userRepository.save(userEntity);
            })
            .orElseThrow(() -> new RuntimeException("User Not Found!!!"));
    }
}
