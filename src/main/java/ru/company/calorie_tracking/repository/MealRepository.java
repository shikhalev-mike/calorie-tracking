package ru.company.calorie_tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.calorie_tracking.entity.Meal;

import java.time.LocalDate;
import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {
    List<Meal> findByUser_IdAndDate(Long id, LocalDate date);
}