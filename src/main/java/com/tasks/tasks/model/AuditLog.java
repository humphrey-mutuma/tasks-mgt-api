package com.tasks.tasks.model;

import jakarta.persistence.*;
import lombok.*;
 import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "logs")
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String entityName;  // Task or Tag
    private Long entityId;
    private String action;      // CREATED, UPDATED, DELETED
    private String description;
    private LocalDateTime timestamp;
}
