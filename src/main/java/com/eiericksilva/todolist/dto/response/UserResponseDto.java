package com.eiericksilva.todolist.dto.response;

import com.eiericksilva.todolist.entities.Task;
import java.util.List;


public class UserResponseDto {
    private Long id;
    private String name;
    private List<Task> tasks;

    public UserResponseDto() {
    }

    public UserResponseDto(Long id, String name, List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.tasks = tasks;
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
