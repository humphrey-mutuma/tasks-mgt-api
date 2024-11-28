package com.tasks.tasks.repository;

import com.tasks.tasks.dto.tasks.FindTaskResDto;
import com.tasks.tasks.model.Task;
 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing {@link Task} entities.
 *
 * This interface provides CRUD operations and custom queries for interacting with the database.
 * Extent {@link JpaRepository},
 * provides built-in basic CRUD operations
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

 @Query( value = """
         SELECT
             t.id,
             t.title,
             t.description,
             t.status,
             t.created_at,
             t.updated_at,
             ARRAY_AGG(tg.tagname) AS tags
         FROM
             tasks t
         INNER JOIN
             task_tags tt
             ON tt.task_id = t.id
         INNER JOIN
             tags tg
             ON tg.id = tt.tag_id
         WHERE
             t.user_id = :userId
          GROUP BY
             t.id
         ORDER BY
             t.id
         LIMIT :limit
         OFFSET :offset ;
           """,
         nativeQuery = true
 )
 List<FindTaskResDto> findUserTasks(
          @Param("limit") int limit,
         @Param("offset") int offset,
         @Param("userId") Long userId
 );
}
