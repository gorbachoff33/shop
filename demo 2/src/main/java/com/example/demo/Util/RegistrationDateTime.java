package com.example.demo.Util;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Component
public class RegistrationDateTime {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Timestamp getRegisterDateTime(){
        return Timestamp.valueOf(LocalDateTime.now().format(formatter));
    }
}
