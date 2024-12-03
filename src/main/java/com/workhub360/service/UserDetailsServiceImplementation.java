package com.workhub360.service;

import com.workhub360.config.UserPrincipal;
import com.workhub360.model.User;
import com.workhub360.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userRepository.findByUserName(username);
            if (user == null) {
                throw new UsernameNotFoundException("User not found: " + username);
            }

            return new UserPrincipal(user);
        } catch (Exception e) {
            throw new RuntimeException("Error loading user by username", e);
        }
    }
}
