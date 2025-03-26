package ru.company.calorie_tracking.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.company.calorie_tracking.dto.MealDishDTO;
import ru.company.calorie_tracking.entity.MealDish;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {DishMapper.class, MealMapper.class})
public interface MealDishMapper {
    MealDish toEntity(MealDishDTO mealDishDTO);

    @Mapping(target = "dishDTO", source = "dish") // Явно указываем маппинг user → userDTO
    MealDishDTO toMealDishDTO(MealDish mealDish);
}