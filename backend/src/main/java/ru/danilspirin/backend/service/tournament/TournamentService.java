package ru.danilspirin.backend.service.tournament;

import ru.danilspirin.backend.model.enitiy.TournamentModel;

import java.util.List;

public interface TournamentService {

    List<TournamentModel> getTournamentList();

    TournamentModel getTournament(Long tournamentId);

    TournamentModel createTournament(TournamentModel tournament);

    TournamentModel replaceTournament(Long tournamentId, TournamentModel tournamentToReplace);

    void deleteTournament(Long tournamentId);
}