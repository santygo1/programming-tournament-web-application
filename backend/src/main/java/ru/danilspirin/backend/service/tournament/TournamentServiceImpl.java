package ru.danilspirin.backend.service.tournament;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.danilspirin.backend.model.Task;
import ru.danilspirin.backend.model.records.Category;
import ru.danilspirin.backend.dto.FilterRequest;
import ru.danilspirin.backend.exception.tournament.TournamentNotFoundException;
import ru.danilspirin.backend.model.Tournament;
import ru.danilspirin.backend.repository.TournamentRepository;
import ru.danilspirin.backend.repository.TournamentSpecifications;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;


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
    public Set<Task> getTournamentTasksList(Long tournamentId) {
        return getTournament(tournamentId).getTasks();
    }

    public List<Tournament> getTournamentList(Optional<Category> category, Optional<FilterRequest> filter, Sort sort) {
        Specification<Tournament> spec = Specification.where(TournamentSpecifications.findByCategory(category));

        if (filter.isPresent()) {
            spec = switch (filter.get()) {
                case ACTIVE ->
                        spec.and((root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("finishDate"), LocalDate.now()));
                case PAST ->
                        spec.and((root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("finishDate"), LocalDate.now()));
                default -> spec;
            };
        }
        return tournamentRepository.findAll(spec, sort);
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