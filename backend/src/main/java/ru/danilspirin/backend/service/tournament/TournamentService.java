package ru.danilspirin.backend.service.tournament;

import ru.danilspirin.backend.model.Tournament;

import java.util.List;

public interface TournamentService {

    List<Tournament> getTournamentList();

    Tournament getTournament(Long tournamentId);

    Tournament createTournament(Tournament tournament);

    Tournament replaceTournament(Long tournamentId, Tournament tournamentToReplace);

    void deleteTournament(Long tournamentId);
}