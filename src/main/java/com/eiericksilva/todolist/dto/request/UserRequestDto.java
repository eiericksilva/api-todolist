package com.eiericksilva.todolist.dto.request;

import com.eiericksilva.todolist.entities.Task;

import java.util.List;

public class UserRequestDto {
    private String name;
    private String password;
    private List<Task> tasks;

    public UserRequestDto() {
    }

    public UserRequestDto(String name, String password, List<Task> tasks) {
        this.name = name;
        this.password = password;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }
}
