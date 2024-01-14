package ru.danilspirin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.danilspirin.backend.model.Tournament;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
}