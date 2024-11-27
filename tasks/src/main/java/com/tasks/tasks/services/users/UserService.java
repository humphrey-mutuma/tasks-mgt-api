package com.tasks.tasks.services.users;

import com.tasks.tasks.dto.users.FindUserProfileDto;
import com.tasks.tasks.dto.users.UpdateUserProfileDto;
import com.tasks.tasks.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
    private final UserRepository userRepository;
    @Override
    public FindUserProfileDto findUserProfile(String username) {
        return null;
    }

    @Override
    public String updateUserProfile(String username, UpdateUserProfileDto updateUserProfileDto) {
        return "";
    }

    @Override
    public String deleteUser(Long userId) {
        return "";
    }
}
