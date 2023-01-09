package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TodoService {
    public ArrayList<String> getAllTodos() {
        ArrayList<String> todos = new ArrayList<>();
        todos.add("Make Lunch");
        todos.add("Charge Laptop");
        todos.add("Pack bag");

        return todos;
    }

    public String getTodoByName() {
        return null;
    }
}
