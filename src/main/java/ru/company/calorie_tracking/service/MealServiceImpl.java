package ru.company.calorie_tracking.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ru.company.calorie_tracking.dto.MealDTO;
import ru.company.calorie_tracking.entity.Dish;
import ru.company.calorie_tracking.entity.Meal;
import ru.company.calorie_tracking.entity.MealDish;
import ru.company.calorie_tracking.entity.User;
import ru.company.calorie_tracking.mapper.MealMapper;
import ru.company.calorie_tracking.repository.DishRepository;
import ru.company.calorie_tracking.repository.MealRepository;
import ru.company.calorie_tracking.repository.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MealServiceImpl implements MealService{

    private final MealRepository mealRepository;

    private final DishRepository dishRepository;

    private final MealMapper mealMapper;

    private final UserRepository userRepository;

    public MealServiceImpl(MealRepository mealRepository,
                           DishRepository dishRepository,
                           MealMapper mealMapper,
                           UserRepository userRepository) {
        this.mealRepository = mealRepository;
        this.dishRepository = dishRepository;
        this.mealMapper = mealMapper;
        this.userRepository = userRepository;
    }

    @Override
    public MealDTO createMeal(Long userId, List<Long> dishesId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        List<Dish> dishes = dishesId.stream()
                .map(dishId -> dishRepository.findById(dishId)
                        .orElseThrow(() -> new EntityNotFoundException("Dish not found with id: " + dishId)))
                .toList();

        if (dishes.isEmpty()) {
            throw new EntityNotFoundException("No dishes found for provided IDs");
        }

        Meal meal = new Meal();
        meal.setUser(user);
        meal.setDate(LocalDate.now());

        List<MealDish> mealDishes = new ArrayList<>();
        for (Dish dish : dishes) {
            MealDish mealDish = new MealDish();
            mealDish.setDish(dish);
            mealDish.setMeal(meal);
            mealDishes.add(mealDish);
        }
        meal.setMealDishes(mealDishes);

        return mealMapper.toMealDTO(mealRepository.save(meal));
    }
}
