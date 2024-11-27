package com.tasks.tasks.repository;

import com.tasks.tasks.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing {@link Tag} entities.
 *
 * This interface provides CRUD operations and custom queries for interacting with the database.
 * Extent {@link JpaRepository},
 * provides built-in basic CRUD operations
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
//    fetch all tags by tagnames
    List<Tag> findAllByTagnameIn(List<String> tagnames);

}
