package com.example.demo.Util;

import com.example.demo.Security.Encription;
import com.example.demo.model.Person;
import com.example.demo.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class RegistrationService {
    private final PeopleRepository peopleRepository;
    private final Encription encription;

    private final RegistrationDateTime registrationDateTime;

    @Autowired
    public RegistrationService(PeopleRepository peopleRepository,Encription encription, RegistrationDateTime registrationDateTime) {
        this.peopleRepository = peopleRepository;
        this.encription = encription;
        this.registrationDateTime = registrationDateTime;
    }
    @Transactional
    public void register(Person person){
      person.setPassword(encription.getPasswordEncoder().encode(person.getPassword()));
      person.setRole("ROLE_USER");
      person.setRegistration_time(registrationDateTime.getRegisterDateTime());

      peopleRepository.save(person);
    }
}

