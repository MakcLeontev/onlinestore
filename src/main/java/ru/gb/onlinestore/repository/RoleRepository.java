package ru.gb.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.onlinestore.model.ERole;
import ru.gb.onlinestore.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
}
