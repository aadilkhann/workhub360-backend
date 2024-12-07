package com.workhub360.repository;

import com.workhub360.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUserName(String username);

    User findAllById(UUID id);
}
