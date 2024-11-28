package com.tasks.tasks.services.users;

 import com.tasks.tasks.dto.users.FindUsersDto;
 import com.tasks.tasks.exceptions.ResourceNotFoundException;
import com.tasks.tasks.exceptions.UnauthorizedException;
 import com.tasks.tasks.model.User;
import com.tasks.tasks.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
     private final UserRepository userRepository;

    @Override
    public List<FindUsersDto> findUsers() {

        try {
            return userRepository.findAllUsers();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
     }

    @Transactional
    @Override
    public String deleteUser(Long userId) {
        //        check if the user exists
        User user_to_delete = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found!"));
        //        Verify ownership
        //        TODO: implement role based access instead
        if (!Objects.equals(user_to_delete.getId(), userId)){
            throw new UnauthorizedException("Not authorized");
        }

        try {

            userRepository.deleteById(userId);
            return "Deleted user successfully";
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
