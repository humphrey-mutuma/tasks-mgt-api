package com.tasks.tasks.auth.repo;

 import com.tasks.tasks.model.User;
 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<User, Long> {
    /**
     * Finds a user by their username.
     * @param username the username to search for
     * @return an Optional containing the User if found, or empty if not
     */
     Optional<User> findByUsername(String username);

}
