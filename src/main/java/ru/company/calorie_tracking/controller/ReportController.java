package ru.company.calorie_tracking.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.company.calorie_tracking.dto.DailyReport;
import ru.company.calorie_tracking.service.ReportService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/report/{userId}")
    public ResponseEntity<DailyReport> getDailyReport(@PathVariable Long userId, @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        if (date == null) {
            date = LocalDate.now();
        }
        return ResponseEntity.ok(reportService.generateDailyReport(userId, date));
    }

    @GetMapping("/history/{userId}")
    public List<DailyReport> getHistory(@PathVariable Long userId, @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return reportService.generateHistoryReport(userId, startDate, endDate);
    }

    @GetMapping("/report/isNorm/{userId}")
    public boolean isNorm(@PathVariable Long userId, @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return reportService.isNorm(userId, date);
    }
}
