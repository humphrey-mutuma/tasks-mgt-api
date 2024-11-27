package com.tasks.tasks.services.tags;

 import com.tasks.tasks.dto.tags.FindTagResDto;
import com.tasks.tasks.dto.tags.FindTagsWithTasksResDto;
 import com.tasks.tasks.model.Tag;

 import java.util.List;
 import java.util.Set;

public interface ITagService {

    Set<Tag> findOrCreateTags(List<String> tagnames);

    List<FindTagResDto> findTags(int page, int pageSize    );

    List<FindTagsWithTasksResDto> findTagsWithTasks(int page, int pageSize  );

    String deleteTag(Long tagId);
}
