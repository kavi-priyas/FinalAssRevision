package com.example.demo.Repositiory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.User;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User>  findByUserName(String userName);
}
