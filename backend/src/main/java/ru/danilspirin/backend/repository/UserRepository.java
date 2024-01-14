package ru.danilspirin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.danilspirin.backend.model.enitiy.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}