package com.tasks.tasks.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a tag in the system.
 * Stores information about the tags
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String tagname;

    @ManyToMany(mappedBy = "tags",  cascade = CascadeType.PERSIST)
    @JsonIgnore // Prevents infinite recursion
    private Set<Task> tasks = new HashSet<>();

    public Tag(String tagname) {
        this.tagname = tagname;
    }
}
