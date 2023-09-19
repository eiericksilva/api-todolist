package com.eiericksilva.todolist.services;

import java.util.List;
import java.util.stream.Collectors;

import com.eiericksilva.todolist.dto.request.UserRequestDto;
import com.eiericksilva.todolist.dto.response.UserResponseDto;
import com.eiericksilva.todolist.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiericksilva.todolist.exceptions.ResourceNotFoundException;
import com.eiericksilva.todolist.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserResponseDto> findAll() {
        var users = userRepository.findAll();
        return users.stream()
                .map(UserMapper::toUserResponseDto)
                .collect(Collectors.toList());
    }

    public UserResponseDto findById(Long id) {
        return userRepository.findById(id).map(UserMapper::toUserResponseDto)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public UserResponseDto create(UserRequestDto userRequestDto) {
        var userEntity = UserMapper.toUser(userRequestDto);
        userRepository.save(userEntity);
        return UserMapper.toUserResponseDto(userEntity);
    }

    public void delete(Long id) {
        userRepository.delete(
                userRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    public UserResponseDto update(Long id, UserRequestDto newUserData) {
        return userRepository.findById(id)
                .map(userFound -> {
                    userFound.setName(newUserData.getName());
                    userFound.setPassword(newUserData.getPassword());

                    return UserMapper.toUserResponseDto(userRepository.save(userFound));
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
