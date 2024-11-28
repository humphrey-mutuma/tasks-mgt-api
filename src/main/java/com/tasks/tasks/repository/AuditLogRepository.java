package com.tasks.tasks.repository;

import com.tasks.tasks.dto.logs.FindLogsDto;
import com.tasks.tasks.dto.tasks.FindTaskResDto;
import com.tasks.tasks.model.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

    @Query( value = """
            SELECT * FROM logs
                     ORDER BY
                         logs.timestamp DESC;
         """,
            nativeQuery = true
    )
    List<FindLogsDto> findAuditLogs(
            @Param("limit") int limit,
            @Param("offset") int offset
     );
}

