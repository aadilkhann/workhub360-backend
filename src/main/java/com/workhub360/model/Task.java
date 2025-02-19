package com.workhub360.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id",unique = true)
    private UUID id;

    private String title;
    private String description;

//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private User assignedTo;

//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @ManyToOne
    @JoinColumn(name = "assigned_by")
    private User assignedBy;

//    @Column(name = "assigned_to")
//    private UUID assignedTo;
//
//    @Column(name = "assigned_by")
//    private UUID assignedBy;

    private String status;

    private Instant created;
    private Instant updated;
    private Instant dueDate;

    private String priority;


    @PrePersist
    public void prePersist() {
        Instant now = Instant.now();
        this.created = now;
        this.updated = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.updated = Instant.now();
    }

}
