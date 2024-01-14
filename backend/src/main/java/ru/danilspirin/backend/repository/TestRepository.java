package ru.danilspirin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.danilspirin.backend.model.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
}