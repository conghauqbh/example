package com.company.example.service;

import com.company.example.dto.TodoDTO;
import com.company.example.entity.Todo;
import com.company.example.repository.TodoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("todoServiceImpl")
@Transactional
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @Override
    public TodoDTO getTodoById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found to do with id " + id));
        return new TodoDTO(todo);
    }

    @Override
    public void deleteTodoById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found to do with id " + id));
        todoRepository.delete(todo);
    }

    @Override
    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }
}
