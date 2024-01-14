package ru.danilspirin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.danilspirin.backend.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}