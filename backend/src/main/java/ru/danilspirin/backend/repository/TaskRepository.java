package ru.danilspirin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.danilspirin.backend.model.enitiy.TaskModel;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
}