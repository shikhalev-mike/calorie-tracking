package ru.company.calorie_tracking.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import ru.company.calorie_tracking.entity.MealDish;

/**
 * DTO for {@link MealDish}
 */
public record MealDishDTO(Long id, @JsonManagedReference DishDTO dishDTO, @JsonBackReference MealDTO mealDTO) {
}