package ru.company.calorie_tracking.service;

import org.springframework.stereotype.Service;
import ru.company.calorie_tracking.dto.DailyReport;
import ru.company.calorie_tracking.entity.Dish;
import ru.company.calorie_tracking.entity.Meal;
import ru.company.calorie_tracking.entity.MealDish;
import ru.company.calorie_tracking.entity.User;
import ru.company.calorie_tracking.mapper.MealMapper;
import ru.company.calorie_tracking.repository.MealRepository;
import ru.company.calorie_tracking.repository.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {

    private final MealRepository mealRepository;

    private final UserRepository userRepository;

    private final MealMapper mealMapper;

    public ReportServiceImpl(MealRepository mealRepository, UserRepository userRepository, MealMapper mealMapper) {
        this.mealRepository = mealRepository;
        this.userRepository = userRepository;
        this.mealMapper = mealMapper;
    }

    @Override
    public DailyReport generateDailyReport(Long userId, LocalDate date) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            return null;
        }

        List<Meal> meals = mealRepository.findByUser_IdAndDate(userId, date);
        List<MealDish> mealDishes = new ArrayList<>();
        List<Dish> dishes = new ArrayList<>();
        for (Meal meal : meals) {
            mealDishes.addAll(meal.getMealDishes());
        }
        for (MealDish mealDish : mealDishes) {
            dishes.add(mealDish.getDish());
        }

        double totalCalories = dishes.stream().mapToDouble(Dish::getCalories).sum();


        boolean withinLimit = totalCalories <= user.get().getDailyCalorieNorm();

        return new DailyReport(date, totalCalories, user.get().getDailyCalorieNorm(), withinLimit, mealMapper.toMealDTO(meals));
    }

    @Override
    public List<DailyReport> generateHistoryReport(Long userId, LocalDate start, LocalDate end) {
        List<DailyReport> dailyReports = new ArrayList<>();
        LocalDate current = start;
        while (!current.isAfter(end)) {
            dailyReports.add(generateDailyReport(userId, current));
            current = current.plusDays(1);
        }
        return dailyReports;
    }

    @Override
    public boolean isNorm(Long userId, LocalDate date) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new RuntimeException();
        }

        List<Meal> meals = mealRepository.findByUser_IdAndDate(userId, date);
        List<MealDish> mealDishes = new ArrayList<>();
        List<Dish> dishes = new ArrayList<>();
        for (Meal meal : meals) {
            mealDishes.addAll(meal.getMealDishes());
        }
        for (MealDish mealDish : mealDishes) {
            dishes.add(mealDish.getDish());
        }

        double totalCalories = dishes.stream().mapToDouble(Dish::getCalories).sum();
        return totalCalories <= user.get().getDailyCalorieNorm();
    }
}
