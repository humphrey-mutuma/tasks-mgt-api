package com.tasks.tasks.services.users;

import com.tasks.tasks.dto.users.FindUsersDto;

import java.util.List;

public interface IUserService {

    /**
     * Fetches the profile details of a single user by username.
     *
     * This method retrieves the profile details of a user based on their username. It returns
     * a {@link FindUsersDto} that represents the user's profile data.
     *
     * @param username the username of the user whose profile is to be fetched
     * @return {@link FindUsersDto} containing the user's profile information
     * @throws UserNotFoundException if the user is not found
     */
    List<FindUsersDto> findUsers();


    /**
     * Deletes a user from the system.
     *
     * This method removes a user from the system based on their unique user ID.
     *
     * @param userId the unique identifier of the user to delete
     * @return a success message confirming that the user has been deleted
     * @throws UserNotFoundException if the user with the given ID does not exist
     */
    String deleteUser(Long userId);
}
