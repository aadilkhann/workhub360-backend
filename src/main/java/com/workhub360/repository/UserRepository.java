package com.workhub360.repository;

import com.workhub360.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);

    User findAllById(Long id);
}
