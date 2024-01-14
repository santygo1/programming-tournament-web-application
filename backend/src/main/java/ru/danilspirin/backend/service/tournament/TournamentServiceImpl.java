package ru.danilspirin.backend.service.tournament;

import org.springframework.stereotype.Service;
import ru.danilspirin.backend.exception.tournament.TournamentNotFoundException;
import ru.danilspirin.backend.model.enitiy.TournamentModel;
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
    public List<TournamentModel> getTournamentList() {
        return tournamentRepository.findAll();
    }

    @Override
    public TournamentModel getTournament(Long tournamentId) {
        Optional<TournamentModel> findById = tournamentRepository.findById(tournamentId);

        if (findById.isEmpty()) {
            throw new TournamentNotFoundException(tournamentId);
        }

        return findById.get();
    }

    @Override
    public TournamentModel createTournament(TournamentModel tournament) {
        return tournamentRepository.save(tournament);
    }

    @Override
    public TournamentModel replaceTournament(Long tournamentId, TournamentModel tournamentToReplace) {
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