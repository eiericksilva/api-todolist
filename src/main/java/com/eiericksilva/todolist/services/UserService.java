package com.eiericksilva.todolist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eiericksilva.todolist.entities.User;
import com.eiericksilva.todolist.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(Long id, User newUserData) {
        User userRef = userRepository.getReferenceById(id);
        updateUserData(userRef, newUserData);
        return userRepository.save(userRef);
    }

    private void updateUserData(User userRef, User newUserData) {
        userRef.setName(newUserData.getName());
        userRef.setPassword(newUserData.getPassword());
    }

}
