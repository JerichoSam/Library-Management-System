package com.library.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.management.entity.UsersEntity;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Integer> {

    List<UsersEntity> findUsersByUserId(Integer userId);
    Optional<UsersEntity> findByEmail(String email);
}
