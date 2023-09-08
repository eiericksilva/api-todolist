package com.eiericksilva.todolist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiericksilva.todolist.entities.Task;
import com.eiericksilva.todolist.exceptions.ResourceNotFoundException;
import com.eiericksilva.todolist.repositories.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {

        Optional<Task> task = taskRepository.findById(id);

        return task.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.delete(
                taskRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    public Optional<Task> update(Long id, Task newTaskData) {
        return taskRepository.findById(id)
                .map(taskFound -> {
                    taskFound.setTitle(newTaskData.getTitle());
                    taskFound.setDescription(newTaskData.getDescription());
                    taskFound.setIsCompleted(newTaskData.getIsCompleted());
                    taskFound.setDeadline(newTaskData.getDeadline());
                    taskFound.setCategory(newTaskData.getCategory());
                    taskFound.setPriority(newTaskData.getPriority());
                    return taskRepository.save(taskFound);
                });
    }
}
