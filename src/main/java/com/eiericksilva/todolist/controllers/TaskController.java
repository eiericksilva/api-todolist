package com.eiericksilva.todolist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eiericksilva.todolist.entities.Task;
import com.eiericksilva.todolist.services.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> findAll() {
        List<Task> tasks = taskService.findAll();
        return ResponseEntity.ok().body(tasks);
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task) {

        var taskObj = taskService.create(task);
        return ResponseEntity.ok().body(taskObj);
    }

}
