package com.example.demo.Security;

import com.example.demo.model.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;

public class PersonDetails implements UserDetails {
    private final Person person;
    public PersonDetails(Person person) {
        this.person = person;
    }
    public Person getPerson() {
        return person;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println(person.getRole());
        return Collections.singletonList(new SimpleGrantedAuthority(person.getRole()));
    }
    @Override
    public String getPassword() {
        return person.getPassword();
    }

    @Override
    public String getUsername() {
        return person.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
