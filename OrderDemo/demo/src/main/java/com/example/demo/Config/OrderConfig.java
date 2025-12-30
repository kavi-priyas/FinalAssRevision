package com.example.demo.Config;

import java.beans.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class OrderConfig {

    private final AuthenticationProvider authenticationProvider;

    OrderConfig(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        UserDetails u1=User.withUsername("Kavi")
        .password(passwordEncoder.encode("kavi@123"))
        .roles("USER")
        .build();
         UserDetails u2=User.withUsername("XXX")
        .password(passwordEncoder.encode("XXX@123"))
        .roles("USER")
        .build();
         UserDetails u3=User.withUsername("YYY")
        .password(passwordEncoder.encode("yyy@123"))
        .roles("USER")
        .build();
        return new InMemoryUserDetailsManager(u1,u2,u3);
        
    }
    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsService uds){
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider(uds);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
       return http
        .csrf(csrf->csrf.disable())
        .authorizeHttpRequests(auth->auth
            .requestMatchers(HttpMethod.GET,"/api/order/**").hasAnyRole("USER","ADMIN")
           .  requestMatchers("/api/order/**").hasRole("ADMIN")
             .anyRequest().authenticated()
        
        )
      // .httpBasic(Customizer.withDefaults())
      .formLogin(form->form.permitAll())
         .build();
    }
    //optional
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration){
        return authenticationConfiguration.getAuthenticationManager();
    }

}
