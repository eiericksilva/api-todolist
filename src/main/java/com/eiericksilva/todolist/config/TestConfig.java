package com.eiericksilva.todolist.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.eiericksilva.todolist.entities.Task;
import com.eiericksilva.todolist.entities.User;
import com.eiericksilva.todolist.entities.enums.Category;
import com.eiericksilva.todolist.entities.enums.Priority;
import com.eiericksilva.todolist.repositories.TaskRepository;
import com.eiericksilva.todolist.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User();
        u1.setName("João");
        u1.setPassword("12345");

        User u2 = new User();
        u2.setName("Maria");
        u2.setPassword("12345");

        Task t1 = new Task();
        t1.setTitle("Levar cachorro para passear");
        t1.setDescription("Levar os cachorros para passear no parque ao lado de casa");
        t1.setDeadline(LocalDate.parse("2023-09-11"));
        t1.setCategory(Category.HEALTH);
        t1.setPriority(Priority.LOW);
        t1.setUser(u1);

        Task t2 = new Task();
        t2.setTitle("Lavar Banheiro");
        t2.setDescription("Lavar os banheiros e a garagem");
        t2.setDeadline(LocalDate.parse("2023-09-11"));
        t2.setCategory(Category.HOME);
        t2.setPriority(Priority.MEDIUM);
        t2.setUser(u1);

        Task t3 = new Task();
        t3.setTitle("Fazer a janta");
        t3.setDescription("Fazer a janta ao chegar em casa");
        t3.setDeadline(LocalDate.parse("2023-09-15"));
        t3.setCategory(Category.HOME);
        t3.setPriority(Priority.HIGH);
        t3.setUser(u2);

        u1.getTasks().addAll(Arrays.asList(t1, t2));
        u2.getTasks().add(t3);

        userRepository.saveAll(Arrays.asList(u1, u2));
        taskRepository.saveAll(Arrays.asList(t1, t2, t3));

    }
}
