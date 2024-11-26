package com.workhub360.controller;

import com.workhub360.model.User;
import com.workhub360.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUser")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @PostMapping("/save-user")
    public User saveUser(@RequestBody User user) {
        userService.save(user);
        return user;
    }
}
