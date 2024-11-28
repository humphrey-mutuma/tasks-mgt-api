package com.tasks.tasks.services.users;

import com.tasks.tasks.auth.repo.AuthRepository;
import com.tasks.tasks.dto.users.FindUserDto;
import com.tasks.tasks.dto.users.UpdateUserDto;
import com.tasks.tasks.exceptions.ResourceNotFoundException;
import com.tasks.tasks.model.User;
import com.tasks.tasks.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
    private final AuthRepository authRepository;
    private final UserRepository userRepository;
    @Override
    public FindUserDto findUser(String username) {

        try {
            User user = authRepository.findByUsername(username)
                    .orElseThrow(() -> new ResourceNotFoundException("user not found!"));

            // Map User to FindUserDto
            return new FindUserDto(user.getId(), user.getUsername());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
     }

    @Transactional
    @Override
    public String updateUser(String username, UpdateUserDto updateUserDto) {

        return "";
    }

    @Transactional
    @Override
    public String deleteUser(Long userId) {
        return "";
    }
}
