package com.tasks.tasks.services.tags;

 import com.tasks.tasks.dto.tags.FindTagsWithTasksCountResDto;
import com.tasks.tasks.dto.tags.FindTagWithTasksResDto;
import com.tasks.tasks.model.Tag;
import com.tasks.tasks.repository.TagRepository;
  import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagService implements ITagService {
    private final TagRepository tagRepository;

    @Transactional
    @Override
    public Set<Tag> findOrCreateTags(List<String> tagnames) {
        // Validate input
        if (tagnames == null || tagnames.isEmpty()) {
            throw new IllegalArgumentException("Tag names list cannot be null or empty");
        }

        // Find existing tags by name
        List<Tag> existingTags = tagRepository.findAllByTagnameIn(tagnames);
        List<String> existingTagNames = existingTags.stream()
                .map(Tag::getTagname)
                .toList();

        // Filter out new tag names
        List<String> newTagNames = tagnames.stream()
                .filter(tag -> !existingTagNames.contains(tag))
                .distinct() // Ensure no duplicates
                .toList();

        // Create and save new tags
        List<Tag> newTags = newTagNames.stream()
                .map(Tag::new) // Assuming a Tag(String name) constructor
                .collect(Collectors.toList());
        if (!newTags.isEmpty()) {
            tagRepository.saveAll(newTags);
        }

        // Combine existing and newly created tags into a Set
        Set<Tag> allTags = new HashSet<>();
        allTags.addAll(existingTags);
        allTags.addAll(newTags);

        return allTags;
    }

    @Override
    public List<FindTagsWithTasksCountResDto> findTagsWithTasksCount() {

            return tagRepository.findTagsWithTasksCount();
    }

    @Override
    public List<FindTagWithTasksResDto> findTagWithTasks(Long tagId) {
        try {

            return tagRepository.findTagWithTasks(tagId);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

}
