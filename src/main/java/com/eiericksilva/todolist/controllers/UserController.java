package com.eiericksilva.todolist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eiericksilva.todolist.entities.User;
import com.eiericksilva.todolist.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        var listUser = userService.findAll();
        return new ResponseEntity<List<User>>(listUser, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User obj) {
        var newUser = userService.create(obj);
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }
}
