package ru.danilspirin.backend.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.danilspirin.backend.model.Task;
import ru.danilspirin.backend.model.Tournament;

import java.util.List;
import java.util.Set;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAll(Specification<Task> spec, Sort sort);

    Set<Task> getAllByIdIn(List<Long> ids);
}