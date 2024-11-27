package com.tasks.tasks.services.tags;

import com.tasks.tasks.auth.repo.AuthRepository;
import com.tasks.tasks.dto.tags.CreateTagDto;
import com.tasks.tasks.dto.tags.FindTagsResDto;
import com.tasks.tasks.dto.tags.FindTagsWithTasksResDto;
import com.tasks.tasks.dto.users.FindUserDto;
import com.tasks.tasks.dto.users.UpdateUserDto;
import com.tasks.tasks.exceptions.ResourceNotFoundException;
import com.tasks.tasks.model.User;
import com.tasks.tasks.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService implements ITagService {
    private final AuthRepository authRepository;
    private final UserRepository userRepository;

    @Override
    public String createTag(CreateTagDto createTagDto) {
        return "";
    }

    @Override
    public List<FindTagsResDto> findTags(int page, int pageSize) {
        return List.of();
    }

    @Override
    public List<FindTagsWithTasksResDto> findTagsWithTasks(int page, int pageSize) {
        return List.of();
    }

    @Override
    public String deleteTag(Long tagId) {
        return "";
    }
}
