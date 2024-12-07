package com.workhub360.controller;

import com.workhub360.model.Task;
import com.workhub360.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task newTask=taskService.createTask(task);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Task>> getUserTask(@PathVariable UUID id) {
        List<Task> tasks= taskService.getUserTask(id);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
