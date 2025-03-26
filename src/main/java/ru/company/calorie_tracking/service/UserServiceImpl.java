package ru.company.calorie_tracking.service;

import org.springframework.stereotype.Service;
import ru.company.calorie_tracking.dto.UserDTO;
import ru.company.calorie_tracking.mapper.UserMapper;
import ru.company.calorie_tracking.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    public UserServiceImpl(UserMapper userMapper,
                           UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return userMapper.toUserDTO(userRepository.save(userMapper.toEntity(userDTO)));
    }
}
