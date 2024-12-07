package com.workhub360.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Indexed;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", schema = "public", indexes = {
        @Index(name = "idx_username", columnList = "username")
})
public class User {

    @Id
    @Column(name = "user_id",unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "username", nullable = false, unique = true)
    private String userName;
    private String name;
    private String email;
    private String password;
    private String role;

    public User(UUID uuid) {
        this.id = uuid;
    }
}
