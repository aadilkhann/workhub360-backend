package com.workhub360.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teams {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_id",unique = true)
    private UUID id;
    @Column(nullable = false)
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "leader_user_id")
    private User leader;
    private Instant created;

    @PrePersist
    public void prePersist() {
        Instant now = Instant.now();
        this.created = now;
    }
}
