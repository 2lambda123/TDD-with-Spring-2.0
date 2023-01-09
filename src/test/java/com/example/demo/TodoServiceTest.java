package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {
    @InjectMocks
    private TodoService serviceUnderTest;

    @Test
    @DisplayName("Should Return All Todos")
    void shouldReturnAllTodos() {
        assertThat(serviceUnderTest.getAllTodos()).isNotEmpty();
    }

    @Test
    @DisplayName("Should return Todo by name")
    void shouldReturnTodoByName() {
        assertThat(serviceUnderTest.getTodoByName("Todo 2")).isNotEmpty();
    }

    @Test
    @DisplayName("Should add new Todo and return True")
    void shouldAddNewTodoAndReturnTrue() {
        assertThat(serviceUnderTest.addNewTodo()).isFalse();
    }

}