package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins = "http://localhost:3000")
public class PlayerController {

    private final CricketRepository repository;

    public PlayerController(CricketRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return repository.findAll();
    }

    @GetMapping("/search")
    public List<Player> searchPlayers(@RequestParam String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
}
