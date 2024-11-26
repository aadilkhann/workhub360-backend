package com.workhub360.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Indexed;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "public", indexes = {
        @Index(name = "idx_username", columnList = "username")
})
public class User {

    @Id
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    private String name;
    private String email;
}
