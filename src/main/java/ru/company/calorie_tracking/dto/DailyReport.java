package ru.company.calorie_tracking.dto;

import java.time.LocalDate;
import java.util.List;

public record DailyReport(LocalDate date, double totalCalories, double dailyNorm, boolean withinLimit,
                          List<MealDTO> mealDTOList) {
}
