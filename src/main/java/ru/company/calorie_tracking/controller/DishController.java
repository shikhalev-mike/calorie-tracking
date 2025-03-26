package ru.company.calorie_tracking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.company.calorie_tracking.dto.DishDTO;
import ru.company.calorie_tracking.entity.Dish;
import ru.company.calorie_tracking.repository.DishRepository;
import ru.company.calorie_tracking.service.DishService;

import java.util.List;

@RestController
@RequestMapping("api/dishes")
public class DishController {

    private final DishService dishService;

    private final DishRepository dishRepository;

    public DishController(DishService dishService, DishRepository dishRepository) {
        this.dishService = dishService;
        this.dishRepository = dishRepository;
    }

    @GetMapping
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<DishDTO> createDish(@RequestBody DishDTO dishDTO) {
        return new ResponseEntity<>(dishService.createDish(dishDTO), HttpStatus.CREATED);
    }
}
