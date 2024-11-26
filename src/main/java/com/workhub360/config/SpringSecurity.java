package com.workhub360.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Disable CSRF for stateless apps (like REST APIs)
                .authorizeHttpRequests(request ->
                        request
                                .requestMatchers("/api/v1/user/**").permitAll()  // Allow public access to this endpoint
                                .requestMatchers("/api/v1/admin/**").hasRole("ADMIN")
                                .anyRequest().authenticated()  // All other requests require authentication
                )
                .formLogin(Customizer.withDefaults())  // Default form login page
                .httpBasic(Customizer.withDefaults());  // Allow HTTP Basic authentication

        return http.build();
    }
}
