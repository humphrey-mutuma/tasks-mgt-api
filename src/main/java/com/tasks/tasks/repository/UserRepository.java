package com.tasks.tasks.repository;

import com.tasks.tasks.dto.users.FindUsersDto;
import com.tasks.tasks.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Repository interface for managing {@link User} entities.
 *
 * This interface provides CRUD operations and custom queries for interacting with the database.
 * Extent {@link JpaRepository},
 * provides built-in basic CRUD operations
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = """
            SELECT
                 u.id,
                 u.username,
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
            FROM users u
            LEFT JOIN tasks t on t.user_id = u.id
            GROUP BY u.id;
            """,
    nativeQuery = true)
    List<FindUsersDto> findAllUsers();
}
