package com.eiericksilva.todolist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eiericksilva.todolist.entities.Task;
import com.eiericksilva.todolist.services.TaskService;

import jakarta.validation.Valid;

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

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        var task = taskService.findById(id);
        return ResponseEntity.ok().body(task);
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody @Valid Task task) {
        var taskObj = taskService.create(task);
        return ResponseEntity.ok().body(taskObj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable @Valid Long id, @RequestBody Task task) {
        return taskService.update(id, task)
                .map(taskFound -> ResponseEntity.ok().body(taskFound))
                .orElse(ResponseEntity.notFound().build());

    }
}
