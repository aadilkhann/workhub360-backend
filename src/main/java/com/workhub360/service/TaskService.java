package com.workhub360.service;

import com.workhub360.model.Task;
import com.workhub360.model.User;
import com.workhub360.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getUserTask(UUID uuid) {
        User user=new User(uuid);
        return taskRepository.findByAssignedTo(user);
    }
}
