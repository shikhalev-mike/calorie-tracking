package ru.company.calorie_tracking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.company.calorie_tracking.dto.MealDTO;
import ru.company.calorie_tracking.mapper.MealMapper;
import ru.company.calorie_tracking.repository.MealRepository;
import ru.company.calorie_tracking.service.MealService;

import java.util.List;

@RestController
@RequestMapping("api/meals")
public class MealController {

    private final MealService mealService;

    private final MealRepository mealRepository;

    private final MealMapper mealMapper;

    public MealController(MealService mealService, MealRepository mealRepository, MealMapper mealMapper) {
        this.mealService = mealService;
        this.mealRepository = mealRepository;
        this.mealMapper = mealMapper;
    }

    @GetMapping
    public List<MealDTO> getAllMeals() {
        return mealMapper.toMealDTO(mealRepository.findAll());
    }

    @PostMapping("/{userId}")
    public ResponseEntity<MealDTO> createMeal(@PathVariable Long userId, @RequestBody List<Long> dishesId) {
        return new ResponseEntity<>(mealService.createMeal(userId, dishesId), HttpStatus.CREATED);
    }
}