package ru.company.calorie_tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.calorie_tracking.entity.MealDish;

public interface MealDishRepository extends JpaRepository<MealDish, Long> {
}