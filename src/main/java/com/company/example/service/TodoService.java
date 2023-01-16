package com.company.example.service;

import com.company.example.dto.TodoDTO;
import com.company.example.entity.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getTodos();

    TodoDTO getTodoById(Long id);

    void deleteTodoById(Long id);

    Todo saveTodo(Todo todo);
}
