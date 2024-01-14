package ru.danilspirin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.danilspirin.backend.model.enitiy.TournamentModel;

public interface TournamentRepository extends JpaRepository<TournamentModel, Long> {
}