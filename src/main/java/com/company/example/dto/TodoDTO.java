package com.company.example.dto;

import com.company.example.entity.Todo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class TodoDTO {

    private Long id;

    private String description;

    private String targetDate;

    public TodoDTO(Todo todo) {
        this.id = todo.getId();
        this.description = todo.getDescription();
        this.targetDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(todo.getTargetDate());
    }
}
