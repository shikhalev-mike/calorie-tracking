package ru.company.calorie_tracking.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.company.calorie_tracking.dto.MealDTO;
import ru.company.calorie_tracking.entity.Meal;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {MealDishMapper.class, UserMapper.class})
public interface MealMapper {
    Meal toEntity(MealDTO mealDTO);

    @Mapping(target = "userDTO", source = "user")
    @Mapping(target = "mealDishDTOList", source = "mealDishes")
    MealDTO toMealDTO(Meal meal);

    List<Meal> toEntity(List<MealDTO> mealDTOs);

    List<MealDTO> toMealDTO(List<Meal> meals);
}