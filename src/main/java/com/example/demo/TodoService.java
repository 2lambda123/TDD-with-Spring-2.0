package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public ArrayList<String> getAllTodos() {
        ArrayList<String> todos = new ArrayList<>();
        todos.add("Make Lunch");
        todos.add("Charge Laptop");
        todos.add("Pack bag");

        return todos;
    }

    public Todo getTodoByName(String title) {
        return todoRepository.findTodoByTitle(title);
    }

    public boolean addNewTodo(Todo todo) {
        if (todoRepository.findTodoByTitle(todo.getTitle()) != null) {
            throw new RuntimeException("Todo with same title already exists before");
        }
        todoRepository.save(todo);
        return true;
    }

    public boolean addAllTodos(List<Todo> todoList) {
        todoRepository.saveAll(todoList);
        return true;
    }
}
