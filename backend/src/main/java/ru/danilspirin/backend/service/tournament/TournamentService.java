package ru.danilspirin.backend.service.tournament;

import ru.danilspirin.backend.model.Task;
import ru.danilspirin.backend.model.Tournament;

import java.util.List;
import java.util.Set;

public interface TournamentService {

    List<Tournament> getTournamentList();

    Set<Task> getTournamentTasksList(Long tournamentId);

    Tournament getTournament(Long tournamentId);

    Tournament createTournament(Tournament tournament);

    Tournament replaceTournament(Long tournamentId, Tournament tournamentToReplace);

    void deleteTournament(Long tournamentId);
}