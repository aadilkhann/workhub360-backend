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
public class TeamMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teamMember_id",unique = true)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Teams team;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Instant addedAt;
}
