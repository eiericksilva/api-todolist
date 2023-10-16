package com.eiericksilva.todolist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eiericksilva.todolist.entities.Task;
import com.eiericksilva.todolist.services.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users/{userId}/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Task create(@PathVariable Long userId, @RequestBody @Valid Task task) {
        System.out.println("Chegou no Controller");
        return taskService.createTask(userId, task);
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAll(@PathVariable Long userId) {
        List<Task> tasks = taskService.findAllTasksByUserId(userId);
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping("/{taskId}")
    public Task findById(@PathVariable Long taskId) {
        return taskService.findTaskById(taskId);
    }

    @PutMapping("/{taskId}")
    public Task fullUpdate(@PathVariable Long taskId, @RequestBody @Valid Task task) {
        return taskService.fullUpdate(taskId, task);
    }

    @PatchMapping("/{taskId}/completed")
    public Task handleTaskIsCompleted(@PathVariable Long taskId) {
        return taskService.handleTaskIsCompleted(taskId);
    }

    @PatchMapping("/{taskId}")
    public Task partialUpdate(@PathVariable Long taskId, @RequestBody Task data) {
        return taskService.partialUpdate(taskId, data);
    }

    @DeleteMapping("/{taskId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long userId, @PathVariable Long taskId) {
        taskService.delete(userId, taskId);
    }
}
