package com.tasks.tasks.repository;

import com.tasks.tasks.model.Task;
 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing {@link Task} entities.
 *
 * This interface provides CRUD operations and custom queries for interacting with the database.
 * Extent {@link JpaRepository},
 * provides built-in basic CRUD operations
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
