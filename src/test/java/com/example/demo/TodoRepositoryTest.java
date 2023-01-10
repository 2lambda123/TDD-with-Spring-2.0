package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class TodoRepositoryTest {
    @Autowired
    private TodoRepository repositoryUnderTest;

    @BeforeEach
    void setUp() {
        Todo todo = new Todo(1, "Todo 1", "Clean desk");
        repositoryUnderTest.save(todo);
    }

    @Test
    @DisplayName("Should find todo by title")
    void shouldFindTodoByTitle() {
        assertThat(repositoryUnderTest.findTodoByTitle("Todo 1")).isNotNull();
    }

    @Test
    @DisplayName("Should return null if todo not found by title")
    void shouldReturnNullIfTodoNotFoundByTitle() {
        assertThat(repositoryUnderTest.findTodoByTitle("Todo 2")).isNull();
    }
}