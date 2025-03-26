package ru.company.calorie_tracking.service;

import ru.company.calorie_tracking.dto.DishDTO;
import ru.company.calorie_tracking.dto.MealDTO;

import java.util.List;

public interface MealService {
    MealDTO createMeal(Long userId, List<Long> dishesId);
}
