package com.example.demo.Security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Encription {
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public Encription(){}
    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }


}
