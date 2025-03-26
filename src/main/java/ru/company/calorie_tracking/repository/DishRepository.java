package ru.company.calorie_tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.calorie_tracking.entity.Dish;

import java.util.Optional;

public interface DishRepository extends JpaRepository<Dish, Long> {
    Optional<Dish> findByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCase(String name);
}