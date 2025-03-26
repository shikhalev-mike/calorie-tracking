package ru.company.calorie_tracking.dto;

import ru.company.calorie_tracking.entity.Gender;
import ru.company.calorie_tracking.entity.Goal;
import ru.company.calorie_tracking.entity.User;

/**
 * DTO for {@link User}
 */
public record UserDTO(Long id, String name, String email, int age, double weight, double height, Gender gender,
                      Goal goal) {
}