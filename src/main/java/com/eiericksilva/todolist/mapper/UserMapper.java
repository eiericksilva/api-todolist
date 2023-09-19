package com.eiericksilva.todolist.mapper;

import com.eiericksilva.todolist.dto.request.UserRequestDto;
import com.eiericksilva.todolist.dto.response.UserResponseDto;
import com.eiericksilva.todolist.entities.User;

public class UserMapper {

    public static User toUser(UserRequestDto userRequestDto) {
        User user = new User();

        user.setName(userRequestDto.getName());
        user.setPassword(userRequestDto.getPassword());
        user.setTasks(userRequestDto.getTasks());

        return user;
    }

    public static UserResponseDto toUserResponseDto(User user) {
        UserResponseDto userDto = new UserResponseDto();

        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setTasks(user.getTasks());

        return userDto;
    }
}
