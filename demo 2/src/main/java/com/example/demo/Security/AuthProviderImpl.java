package com.example.demo.Security;

import com.example.demo.Security.Services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthProviderImpl implements AuthenticationProvider {
    private final PersonDetailsService personDetailsService;
    private final Encription encription;

    @Autowired
    public AuthProviderImpl(PersonDetailsService personDetailsService, Encription encription) {
        this.personDetailsService = personDetailsService;
        this.encription = encription;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserDetails personDetails = personDetailsService.loadUserByUsername(authentication.getName());

        if(!encription.getPasswordEncoder().matches(authentication.getCredentials().toString(),personDetails.getPassword())){
            throw new BadCredentialsException("Incorrect password");
        }
        return new UsernamePasswordAuthenticationToken(personDetails,personDetails.getPassword(),
                personDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
