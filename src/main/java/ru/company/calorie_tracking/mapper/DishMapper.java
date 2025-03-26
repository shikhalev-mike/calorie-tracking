package ru.company.calorie_tracking.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.company.calorie_tracking.dto.DishDTO;
import ru.company.calorie_tracking.entity.Dish;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DishMapper {
    Dish toEntity(DishDTO dishDTO);

    DishDTO toDishDTO(Dish dish);
}