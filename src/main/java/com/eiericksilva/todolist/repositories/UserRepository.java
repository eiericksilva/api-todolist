package com.eiericksilva.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eiericksilva.todolist.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
