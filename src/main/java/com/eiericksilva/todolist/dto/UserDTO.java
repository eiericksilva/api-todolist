package com.eiericksilva.todolist.dto;

import java.util.List;

import com.eiericksilva.todolist.entities.Task;
import com.eiericksilva.todolist.entities.User;

public class UserDTO {
    private Long id;
    private String name;
    private List<Task> tasks;

    public UserDTO() {
    }

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        tasks = user.getTasks();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
