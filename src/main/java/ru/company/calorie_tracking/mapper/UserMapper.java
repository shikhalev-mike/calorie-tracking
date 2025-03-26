package ru.company.calorie_tracking.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.company.calorie_tracking.entity.User;
import ru.company.calorie_tracking.dto.UserDTO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDTO userDTO);

    UserDTO toUserDTO(User user);
}