package com.workhub360.repository;

import com.workhub360.model.Task;
import com.workhub360.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


public interface TaskRepository extends JpaRepository<Task, UUID> {
    public Task findByTitle(String title);

    public List<Task> findByAssignedTo(User assignedTo);
    public List<Task> findByAssignedBy(User assignedBy);
}
