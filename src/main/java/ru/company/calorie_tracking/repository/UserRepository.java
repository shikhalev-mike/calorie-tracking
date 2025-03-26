package ru.company.calorie_tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.calorie_tracking.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}