package ru.danilspirin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.danilspirin.backend.model.enitiy.TestModel;

public interface TestRepository extends JpaRepository<TestModel, Long> {
}