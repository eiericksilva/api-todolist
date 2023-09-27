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

    @GetMapping
    public ResponseEntity<List<Task>> findAll(@PathVariable Long userId) {
        List<Task> tasks = taskService.findAllTasksByUserId(userId);
        return ResponseEntity.ok().body(tasks);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Task create( @Valid @PathVariable Long userId, @RequestBody Task task) {
        return taskService.createTask(userId, task);
    }

    @GetMapping("/{taskId}")
    public Task findById(@PathVariable Long taskId) {
        return taskService.findTaskById(taskId);
    }

    @DeleteMapping("/{taskId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long userId, @PathVariable Long taskId) {
        taskService.delete(userId, taskId);
    }

    @PutMapping("/{taskId}")
    public Task update(@PathVariable @Valid Long taskId, @RequestBody Task task) {
        return taskService.update(taskId, task);
    }

    @PatchMapping("/{taskId}")
    public Task handleTaskIsCompleted(@PathVariable Long taskId){
        return taskService.handleTaskIsCompleted(taskId);
    }
}
