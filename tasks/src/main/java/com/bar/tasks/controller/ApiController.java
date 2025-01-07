package com.bar.tasks.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping(path = "/tasks")
public class ApiController {

    private List<String> tasks = new ArrayList<>();

    private ObjectMapper objectMapper;

    public ApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @GetMapping
    public ResponseEntity<String> getTasks() throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(tasks));
    }

    @PostMapping
    public ResponseEntity<Void> createTask(@RequestBody String task) throws JsonProcessingException {
        tasks.add(task);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() throws JsonProcessingException {
        tasks.clear();
        return ResponseEntity.noContent().build();
    }
}
