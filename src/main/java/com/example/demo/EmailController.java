package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class EmailController {

    private final EmailRepository emailRepository;

    public EmailController(EmailRepository todoRepository) {
        this.emailRepository = todoRepository;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Email createTodo(@RequestBody Email todo) {
        return emailRepository.save(todo);
    }

    @GetMapping("/")
    public Iterable<Email> getTodos() {
        return emailRepository.findAll();
    }
}