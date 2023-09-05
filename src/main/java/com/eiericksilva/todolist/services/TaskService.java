package com.eiericksilva.todolist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiericksilva.todolist.entities.Task;
import com.eiericksilva.todolist.repositories.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    public Task update(Long id, Task newTaskData) {
        Task taskRef = taskRepository.getReferenceById(id);
        updateTaskData(taskRef, newTaskData);
        return taskRepository.save(taskRef);
    }

    private void updateTaskData(Task taskRef, Task newTaskData) {
        taskRef.setTitle(newTaskData.getTitle());
        taskRef.setDescription(newTaskData.getDescription());
        taskRef.setIsCompleted(newTaskData.getIsCompleted());
        taskRef.setDeadline(newTaskData.getDeadline());
        taskRef.setCategory(newTaskData.getCategory());
        taskRef.setPriority(newTaskData.getPriority());
    }
}
