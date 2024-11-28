package com.tasks.tasks.repository;

import com.tasks.tasks.dto.tags.FindTagWithTasksResDto;
import com.tasks.tasks.dto.tags.FindTagsWithTasksCountResDto;
import com.tasks.tasks.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query(value = """
            SELECT
                     t.id,
                     t.tagname,
                     COUNT(task.id) AS tasksCount
                 FROM
                     tags tg
                 LEFT JOIN
                     task_tags tt  ON tt.tag_id = tg.id
                 LEFT JOIN
                     tasks task  ON task.id = tt.task_id
                 GROUP BY
                     tg.id
                 LIMIT: limit
                 OFFSET: offset;
            """,
    nativeQuery = true)
    List<FindTagsWithTasksCountResDto> findTagsWithTasksCount();

    @Query(value = """
            SELECT
                tg.id,
                tg.tagname,
                COALESCE(
                    json_agg(
                        json_build_object(
                            'id', t.id,
                            'title', t.title,
                            'description', t.description,
                            'status', t.status,
                          	'createdAt', t.created_at,
                          	'updatedAt', t.updated_at
                        )
                    ) FILTER (WHERE t.id IS NOT NULL),
                    '[]'
                ) AS tasks,
                COUNT(t.id) AS taskCount
            FROM
                tags tg
            LEFT JOIN
                task_tags tt ON tg.id = tt.tag_id
            LEFT JOIN
                tasks t ON tt.task_id = t.id
            WHERE
                tg.id = :tagId
            GROUP BY
                tg.id, tg.tagname;
            """
    , nativeQuery = true)
    List<FindTagWithTasksResDto> findTagWithTasks(
             @Param("tagId") Long tagId
    );


}
