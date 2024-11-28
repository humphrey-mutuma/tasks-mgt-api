package com.tasks.tasks.controllers;

 import com.tasks.tasks.dto.logs.FindLogsDto;
 import com.tasks.tasks.services.auditLogs.AuditService;
 import com.tasks.tasks.shared.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/audit-logs")
public class AuditController {
    private final AuditService auditService;

    /**
     * fetch system logs
      * @return user details
     */
    @Operation(summary = "fetch system audit logs", description = "")
    @GetMapping()
    public ResponseEntity<ApiResponse<List<FindLogsDto>>> findAuditLogs(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
     ) {
        List<FindLogsDto> logs =auditService.findAuditLogs(page, pageSize);
        if (logs.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("No logs found", null));
        }
        return ResponseEntity
                .ok(new ApiResponse<>("Fetch logs Successful",logs));
    }

}
