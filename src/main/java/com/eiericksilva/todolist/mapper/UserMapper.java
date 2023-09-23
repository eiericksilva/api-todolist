package com.eiericksilva.todolist.mapper;

import com.eiericksilva.todolist.dto.request.UserRequestDto;
import com.eiericksilva.todolist.dto.response.UserResponseDto;
import com.eiericksilva.todolist.entities.Task;
import com.eiericksilva.todolist.entities.User;

import java.util.List;

public class UserMapper {

    public static User toUser(UserRequestDto userRequestDto) {
        User user = new User();

        user.setName(userRequestDto.getName());
        user.setPassword(userRequestDto.getPassword());

        List<Task> tasksToAdd = userRequestDto.getTasks();
        for (Task task : tasksToAdd) {
            user.addTask(task);
        }
        return user;
    }

    public static UserResponseDto toUserResponseDto(User user) {
        UserResponseDto userDto = new UserResponseDto();

        userDto.setId(user.getId());
        userDto.setName(user.getName());

        List<Task> taskToAdd = user.getTasks();
        for (Task task: taskToAdd) {
            userDto.addTask(task);
        }
        return userDto;
    }
}
