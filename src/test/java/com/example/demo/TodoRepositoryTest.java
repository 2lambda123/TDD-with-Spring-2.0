package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
class TodoRepositoryTest {
    @InjectMocks
    private TodoRepository respositoryUnderTest;

    @Test
    @DisplayName("Should find todo by title")
    void shouldFindTodoByTitle() {

    }
}