package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    @Query
    Todo findTodoByTitle(String title);

    @Query
    Todo findTodoByDescription(String description);

    @Query
    Todo findTodoByTitleAndDescription(String title, String description);
}
