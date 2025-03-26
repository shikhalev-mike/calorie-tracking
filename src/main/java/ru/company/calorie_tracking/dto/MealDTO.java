package ru.company.calorie_tracking.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link ru.company.calorie_tracking.entity.Meal}
 */
public record MealDTO(Long id, UserDTO userDTO, LocalDate date,
                      @JsonManagedReference List<MealDishDTO> mealDishDTOList) {
}