package com.eiericksilva.todolist.dto;

import java.util.List;

import com.eiericksilva.todolist.entities.Task;
import com.eiericksilva.todolist.entities.User;

import lombok.Data;

@Data
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
}
