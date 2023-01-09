package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
    @Mock
    private TodoRepository todoRepository;

    @BeforeAll
    static void beforeAll() {
    }

    @BeforeEach
    void setup() {
        Todo todo1 = new Todo(1, "Todo 1", "Clean desk");
        Todo todo2 = new Todo(2, "Todo 2", "Make lunch");
        Todo todo3 = new Todo(3, "Todo 3", "Cook food");
        ArrayList<Todo> todos = new ArrayList<>();
        todos.add(todo1);
        todos.add(todo2);
        todos.add(todo3);

        todoRepository.saveAll(todos);
    }

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
        Todo todo = Todo.builder()
                .title("Todo 1")
                .description("Clean laptop")
                .build();
        assertThat(serviceUnderTest.addNewTodo(todo)).isTrue();
    }

    @Test
    @DisplayName("Should save all todos and return true")
    void shouldSaveAllTodosAndReturnTrue() {
        ArrayList<Todo> todosToSave = new ArrayList<>();
        todosToSave.add(Todo.builder()
                        .title("Todo 4")
                        .description("Clean room")
                .build());

        todosToSave.add(Todo.builder()
                        .title("Todo 5")
                        .description("Iron clothes")
                .build());
        assertThat(serviceUnderTest.addAllTodos()).isFalse();
    }

}