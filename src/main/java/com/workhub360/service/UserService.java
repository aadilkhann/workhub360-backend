package com.workhub360.service;

import com.workhub360.model.User;
import com.workhub360.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(12);

    public User save(User user) {

        try{
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return user;
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(UUID id) {
        try{
            return userRepository.findAllById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(UUID id) {
        try{
            userRepository.deleteById(id);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
