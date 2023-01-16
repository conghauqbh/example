package com.company.example.controller;

import com.company.example.entity.Todo;
import com.company.example.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.format.DateTimeFormatter;

@Controller
public class TodoController {

    private static final String TODO_PAGE = "todo";

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("todo")
    private String goToTodoPage(Model model) {
        model.addAttribute("todos", todoService.getTodos());
        model.addAttribute("todo", new Todo());
        model.addAttribute("dtf", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return TODO_PAGE;
    }

    @GetMapping("todo/{id}")
    private ResponseEntity<?> getTodo(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.getTodoById(id));
    }

    @DeleteMapping("todo/{id}")
    private ResponseEntity<?> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("todo")
    private String saveTodo(Model model, @Valid @ModelAttribute Todo todo, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("todo", todo);
            model.addAttribute("todos", todoService.getTodos());
            model.addAttribute("dtf", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return "todo";
        }
        todoService.saveTodo(todo);
        if(todo.getId() == null) {
            redirectAttrs.addFlashAttribute("message", "Add new todo successfully");
        } else {
            redirectAttrs.addFlashAttribute("message", "Update todo successfully");
        }

        return "redirect:/todo";
    }
}
