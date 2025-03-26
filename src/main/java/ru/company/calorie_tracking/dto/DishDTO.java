package ru.company.calorie_tracking.dto;

/**
 * DTO for {@link ru.company.calorie_tracking.entity.Dish}
 */
public record DishDTO(Long id, String name, double calories, String proteins, double fats, double carbohydrates) {
}