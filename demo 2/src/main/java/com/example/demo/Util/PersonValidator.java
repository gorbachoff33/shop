package com.example.demo.Util;


import com.example.demo.model.Person;
import com.example.demo.repositories.PeopleRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class PersonValidator implements Validator {
    private final PeopleRepository peopleRepository;

    public PersonValidator(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        Optional<Person> exp = peopleRepository.findByUsername(person.getUsername());
        if(exp.isEmpty()){
            return;
        }
        errors.rejectValue("username", "","Человек с таким именем уже существует");
    }
}
