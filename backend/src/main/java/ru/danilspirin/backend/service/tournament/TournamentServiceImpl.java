package ru.danilspirin.backend.service.tournament;

import org.springframework.stereotype.Service;
import ru.danilspirin.backend.exception.tournament.TournamentNotFoundException;
import ru.danilspirin.backend.model.Tournament;
import ru.danilspirin.backend.repository.TournamentRepository;

import java.util.List;
import java.util.Optional;


@Service
public class TournamentServiceImpl implements TournamentService {

    private final TournamentRepository tournamentRepository;

    public TournamentServiceImpl(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }


    @Override
    public List<Tournament> getTournamentList() {
        return tournamentRepository.findAll();
    }

    @Override
    public Tournament getTournament(Long tournamentId) {
        Optional<Tournament> findById = tournamentRepository.findById(tournamentId);

        if (findById.isEmpty()) {
            throw new TournamentNotFoundException(tournamentId);
        }

        return findById.get();
    }

    @Override
    public Tournament createTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    @Override
    public Tournament replaceTournament(Long tournamentId, Tournament tournamentToReplace) {
        tournamentToReplace.setId(tournamentId);
        return tournamentRepository.save(tournamentToReplace);
    }

    @Override
    public void deleteTournament(Long tournamentId) {
        if (tournamentRepository.existsById(tournamentId)) {
            tournamentRepository.deleteById(tournamentId);
        } else {
            throw new TournamentNotFoundException(tournamentId);
        }
    }
}