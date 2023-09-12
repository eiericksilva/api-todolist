package com.eiericksilva.todolist.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiericksilva.todolist.dto.UserDTO;
import com.eiericksilva.todolist.entities.User;
import com.eiericksilva.todolist.exceptions.ResourceNotFoundException;
import com.eiericksilva.todolist.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        return userRepository.findById(id)
                .map(user -> new UserDTO(user))
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public UserDTO create(User user) {
        return new UserDTO(userRepository.save(user));
    }

    public void delete(Long id) {
        userRepository.delete(
                userRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    public UserDTO update(Long id, User newUserData) {
        return userRepository.findById(id)
                .map(userFound -> {
                    userFound.setName(newUserData.getName());
                    userFound.setPassword(newUserData.getPassword());

                    User updatedUser = userRepository.save(userFound);
                    return new UserDTO(updatedUser);
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
