package com.tasks.tasks.services.tags;

import com.tasks.tasks.dto.tags.CreateTagDto;
import com.tasks.tasks.dto.tags.FindTagsResDto;
import com.tasks.tasks.dto.tags.FindTagsWithTasksResDto;
import com.tasks.tasks.dto.users.FindUserDto;
import com.tasks.tasks.dto.users.UpdateUserDto;

import java.util.List;

public interface ITagService {


    String createTag(CreateTagDto createTagDto);

    List<FindTagsResDto> findTags(int page, int pageSize    );

    List<FindTagsWithTasksResDto> findTagsWithTasks(int page, int pageSize  );

    String deleteTag(Long tagId);
}
