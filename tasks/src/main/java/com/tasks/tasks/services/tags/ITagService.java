package com.tasks.tasks.services.tags;

 import com.tasks.tasks.dto.tags.FindTagsWithTasksCountResDto;
import com.tasks.tasks.dto.tags.FindTagWithTasksResDto;
 import com.tasks.tasks.model.Tag;

 import java.util.List;
 import java.util.Set;

public interface ITagService {

    Set<Tag> findOrCreateTags(List<String> tagnames);

    List<FindTagsWithTasksCountResDto> findTagsWithTasksCount(int page, int pageSize );

    List<FindTagWithTasksResDto> findTagWithTasks(Long tagId, int page, int pageSize);

}
