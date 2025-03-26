package ru.company.calorie_tracking.service;

import ru.company.calorie_tracking.dto.UserDTO;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
}
