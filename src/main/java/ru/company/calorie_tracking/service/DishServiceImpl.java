package ru.company.calorie_tracking.service;

import org.springframework.stereotype.Service;
import ru.company.calorie_tracking.dto.DishDTO;
import ru.company.calorie_tracking.entity.Dish;
import ru.company.calorie_tracking.mapper.DishMapper;
import ru.company.calorie_tracking.repository.DishRepository;

@Service
public class DishServiceImpl implements DishService {

    private final DishMapper dishMapper;

    private final DishRepository dishRepository;

    public DishServiceImpl(DishMapper dishMapper,
                           DishRepository dishRepository) {
        this.dishMapper = dishMapper;
        this.dishRepository = dishRepository;
    }

    @Override
    public DishDTO createDish(DishDTO dishDTO) {
        Dish dish = dishMapper.toEntity(dishDTO);
        if (dishRepository.existsByNameIgnoreCase(dishDTO.name())) {
            return null;
        }
        return dishMapper.toDishDTO(dishRepository.save(dish));
    }
}
