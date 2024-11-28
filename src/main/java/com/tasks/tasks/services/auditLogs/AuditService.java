package com.tasks.tasks.services.auditLogs;

 import com.tasks.tasks.dto.logs.FindLogsDto;
 import com.tasks.tasks.model.AuditLog;
import com.tasks.tasks.repository.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

 import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditService {
    private final AuditLogRepository auditLogRepository;

    /**
     * fetch audit logs
     * @param page
     * @param pageSize
     * @return
     */
     public List<FindLogsDto> findAuditLogs(int page, int pageSize) {
         int offset = (page - 1) * pageSize;

        //fetch logs
        return auditLogRepository.findAuditLogs(pageSize, offset);

    }

    /**
     * method to create change logs
     * @param entityName
     * @param entityId
     * @param action
     * @param description
     */
    public void logChange(String entityName, Long entityId, String action, String description) {
        AuditLog auditLog = new AuditLog();
        auditLog.setEntityName(entityName);
        auditLog.setEntityId(entityId);
        auditLog.setAction(action);
        auditLog.setDescription(description);
        auditLog.setTimestamp(LocalDateTime.now());

        auditLogRepository.save(auditLog);
    }
}
