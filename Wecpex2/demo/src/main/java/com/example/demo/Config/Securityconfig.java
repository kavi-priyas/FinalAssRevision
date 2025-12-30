package com.example.demo.Config;

import com.example.demo.DemoApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class Securityconfig {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .csrf(csrf->csrf.disable())
        .authorizeHttpRequests(auth-> auth
            .requestMatchers(HttpMethod.GET,"/students/**").hasAnyRole("ADMIN","USER")
            .requestMatchers("/students/**").hasRole("ADMIN")
            .anyRequest().authenticated()
            


        )
        .httpBasic(httpBasic -> {});
        return http.build();

    }
}
