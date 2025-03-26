package ru.company.calorie_tracking.service;

import ru.company.calorie_tracking.dto.DailyReport;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {
    DailyReport generateDailyReport(Long userId, LocalDate date);
    List<DailyReport> generateHistoryReport(Long userId, LocalDate start, LocalDate end);
    boolean isNorm(Long userId, LocalDate date);
}
