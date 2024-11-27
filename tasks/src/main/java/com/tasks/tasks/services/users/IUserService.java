package com.tasks.tasks.services.users;

import com.tasks.tasks.dto.users.FindUserProfileDto;
import com.tasks.tasks.dto.users.UpdateUserProfileDto;

public interface IUserService {

    /**
     * Fetches the profile details of a single user by username.
     *
     * This method retrieves the profile details of a user based on their username. It returns
     * a {@link FindUserProfileDto} that represents the user's profile data.
     *
     * @param username the username of the user whose profile is to be fetched
     * @return {@link FindUserProfileDto} containing the user's profile information
     * @throws UserNotFoundException if the user is not found
     */
    FindUserProfileDto findUserProfile(String username);

    /**
     * Updates the details of a user.
     *
     * This method allows updating the profile of an existing user. It accepts a DTO containing
     * the updated user information and applies the changes to the database.
     *
     * @param username the username of the user to update
     * @param updateUserProfileDto DTO containing the updated user data
     * @return a success message indicating that the user's profile has been updated
     * @throws UserNotFoundException if the user is not found
     * @throws InvalidDataException if the provided data is invalid
     */
    String updateUserProfile(
            String username,
            UpdateUserProfileDto updateUserProfileDto
    );

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
