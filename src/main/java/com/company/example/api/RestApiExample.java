package com.company.example.api;

import com.company.example.entity.Todo;
import com.company.example.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class RestApiExample {

    private final TodoService todoService;

    public RestApiExample(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("todos")
    public ResponseEntity<?> getApiExample() {
        return ResponseEntity.ok(todoService.getTodos());
    }

    @GetMapping("todo/{id}")
    public ResponseEntity<?> getApiExampleById(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.getTodoById(id));
    }

    @PostMapping("todo")
    public ResponseEntity<?> postApiExample(Todo todo) {
        Todo result = todoService.saveTodo(todo);
        return ResponseEntity.created(URI.create("todo")).body(result);
    }

    @PutMapping("todo")
    public ResponseEntity<?> putApiExample(Todo todo) {
        Todo result = todoService.saveTodo(todo);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping ("todo/{id}")
    public ResponseEntity<?> deleteApiExample(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return ResponseEntity.noContent().build();
    }
}
