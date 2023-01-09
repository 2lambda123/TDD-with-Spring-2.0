package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
class TodoServiceTest {
    private final TodoService serviceUnderTest;

    @Test
    @DisplayName("Should Return All Todos")
    void shouldReturnAllTodos() {
        return serviceUnderTest.getAllTodos();
    }

}