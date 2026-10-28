package com.example.demodevops;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    // A simple GET endpoint: http://localhost:8080/api/hello?name=Alice
    @GetMapping("/hello")
    public Greeting sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting("Hello, " + name + "!");
    }

    // A simple POST endpoint: http://localhost:8080/api/users
    private final List<User> users = new ArrayList<>();

    @PostMapping("/users")
    public String createUser(@RequestBody User newUser) {
        users.add(newUser);
        return "User " + newUser.name() + " created successfully! Total users: " + users.size();
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return users;
    }

    // Records for clean, boilerplate-free data models (Java 14+)
    public record Greeting(String message) {}
    public record User(String name, String email) {}
}
