package ru.gb.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.onlinestore.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
