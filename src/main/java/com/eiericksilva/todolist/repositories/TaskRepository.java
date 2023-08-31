package com.eiericksilva.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eiericksilva.todolist.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
