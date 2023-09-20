package com.eiericksilva.todolist.services;

import com.eiericksilva.todolist.entities.Task;
import com.eiericksilva.todolist.entities.User;
import com.eiericksilva.todolist.exceptions.ResourceNotFoundException;
import com.eiericksilva.todolist.repositories.TaskRepository;
import com.eiericksilva.todolist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Task create(Long userId, Task task) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(userId));
        user.getTasks().add(task);

        task.setUser(user);

        return taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.delete(
                taskRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    public Task update(Long id, Task newTaskData) {
        return taskRepository.findById(id)
                .map(taskFound -> {
                    taskFound.setTitle(newTaskData.getTitle());
                    taskFound.setDescription(newTaskData.getDescription());
                    taskFound.setIsCompleted(newTaskData.getIsCompleted());
                    taskFound.setDeadline(newTaskData.getDeadline());
                    taskFound.setCategory(newTaskData.getCategory());
                    taskFound.setPriority(newTaskData.getPriority());
                    return taskRepository.save(taskFound);
                }).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
