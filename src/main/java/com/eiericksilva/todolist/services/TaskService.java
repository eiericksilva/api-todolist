package com.eiericksilva.todolist.services;

import com.eiericksilva.todolist.entities.Task;
import com.eiericksilva.todolist.entities.User;
import com.eiericksilva.todolist.exceptions.DataInvalidException;
import com.eiericksilva.todolist.exceptions.ResourceNotFoundException;
import com.eiericksilva.todolist.repositories.TaskRepository;
import com.eiericksilva.todolist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public Task createTask(Long userId, Task task) {
        checkingDeadline(task.getDeadline());

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(userId));
        user.getTasks().add(task);

        task.setUser(user);

        return taskRepository.save(task);
    }

    public List<Task> findAllTasksByUserId(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(userId));

        return user.getTasks();
    }

    public Task findTaskById(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException(taskId));
    }

    public Task handleTaskIsCompleted(Long taskId){
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException(taskId));

        task.setIsCompleted(!task.getIsCompleted());
        return taskRepository.save(task);
    }
    public Task fullUpdate(Long taskId, Task newTaskData) {
        checkingDeadline(newTaskData.getDeadline());
        return taskRepository.findById(taskId)
                .map(taskFound -> {
                    taskFound.setTitle(newTaskData.getTitle());
                    taskFound.setDescription(newTaskData.getDescription());
                    taskFound.setIsCompleted(newTaskData.getIsCompleted());
                    taskFound.setDeadline(newTaskData.getDeadline());
                    taskFound.setCategory(newTaskData.getCategory());
                    taskFound.setPriority(newTaskData.getPriority());
                    return taskRepository.save(taskFound);
                }).orElseThrow(() -> new ResourceNotFoundException(taskId));
    }

    public Task partialUpdate(Long taskId, Task data) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException(taskId));

        if(data.getTitle() != null) {
            task.setTitle(data.getTitle());
        }
        if(data.getDescription() != null) {
            task.setDescription(data.getDescription());
        }
        if(data.getDeadline() != null) {
            task.setDeadline(data.getDeadline());
        }
        if(data.getCategory() != null) {
            task.setCategory(data.getCategory());
        }
        if(data.getPriority() != null) {
            task.setPriority(data.getPriority());
        }
        if(data.getTitle() != null) {
            task.setTitle(data.getTitle());
        }

        return taskRepository.save(task);
    }


    public void delete(Long userId, Long taskId) {
        User userFound = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(userId));
        Task taskToDelete = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException(taskId));

        userFound.removeTask(taskToDelete);
        taskRepository.delete(taskToDelete);

    }

    public void checkingDeadline(LocalDate deadline) {
        LocalDate now = LocalDate.now();

        if (deadline.isBefore(now)) {
            throw new DataInvalidException(deadline);
        }
    }
}
