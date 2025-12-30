package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.Entity.User;
import com.example.demo.Repositiory.UserRepo;

public class CustomUserService implements UserDetailsService {
    @Autowired
    private UserRepo userrepo;
 public CustomUserService(UserRepo userrepo) {
        this.userrepo = userrepo;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException  {
        User user = userrepo.findByUserName(username)
             .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User.builder()
        .username(user.getUserName())
        .password(user.getPassword())
        .roles(user.getRoles())
        .build();


    

    }
    
    
}
