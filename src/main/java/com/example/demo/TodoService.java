package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

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

    public String getTodoByName(String title) {
        HashMap<String, String> todos = new HashMap<>();
        todos.put("Todo 1", "Make Lunch");
        todos.put("Todo 2", "Charge Laptop");
        todos.put("Todo 3", "Pack bag");

        return todos.get(title);
    }

    public boolean addNewTodo(Todo todo) {
        todoRepository.save(todo);
        return true;
    }

    public boolean addAllTodos() {
        return false;
    }
}
