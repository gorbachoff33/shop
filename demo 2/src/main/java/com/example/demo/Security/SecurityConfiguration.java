package com.example.demo.Security;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorizeHttpRequests)->
                {
                authorizeHttpRequests
                .requestMatchers("/adminPages/admin","/adminPages/newProductPage").hasAuthority("ROLE_ADMIN")
                .requestMatchers("/auth/login","/auth/registration","/error").permitAll()
                .anyRequest().hasAnyAuthority("ROLE_USER", "ROLE_ADMIN");
                }).formLogin((formLogin)-> {
                 formLogin
                    .loginPage("/auth/login")
                    .loginProcessingUrl("/process_login")
                    .defaultSuccessUrl("/",true)
                    .failureUrl("/auth/login?error");
        }).logout((logout) -> logout.logoutUrl("/logout")
                        .logoutSuccessUrl("/auth/login"));
         return http.build();
    }
}