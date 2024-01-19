package ru.danilspirin.backend.controller;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.danilspirin.backend.dto.FilterRequest;
import ru.danilspirin.backend.dto.tournament.ReadTournamentDto;
import ru.danilspirin.backend.dto.tournament.WriteTournamentDto;
import ru.danilspirin.backend.exception.UnsupportedCategoryException;
import ru.danilspirin.backend.model.Tournament;
import ru.danilspirin.backend.model.records.Category;
import ru.danilspirin.backend.service.tournament.TournamentServiceImpl;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/tournaments")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class TournamentController {

    final TournamentServiceImpl tournamentService;
    final ModelMapper mapper;

    public TournamentController(TournamentServiceImpl tournamentService, ModelMapper mapper) {
        this.tournamentService = tournamentService;
        this.mapper = mapper;
    }


    @GetMapping
    public ResponseEntity<Iterable<ReadTournamentDto>> getTournamentList(@RequestParam(value = "track", required = false) String categoryRequest,
                                                                         @RequestParam(required = false) String filter,
                                                                         @RequestParam(required = false) String sort) {

        log.info("Получаем список турниров");
        log.info("category: {}", categoryRequest);
        log.info("filter: {}", filter);
        log.info("sort: {}", sort);

        // TODO: Дичь
        Category category = null;
        if (categoryRequest != null && !categoryRequest.equals("ALL")) {
            try {
                category = Category.valueOf(categoryRequest);
            } catch (IllegalArgumentException e) {
                throw new UnsupportedCategoryException(categoryRequest);
            }
        }
        FilterRequest filterRequest = null;
        if (filter != null) {
            try {
                filterRequest = FilterRequest.valueOf(filter);
            } catch (IllegalArgumentException e) {
                throw new UnsupportedCategoryException();
            }
        }

        Sort sortRequest = Sort.unsorted();
        if (sort != null){
            switch (sort) {
                case "NAME_DESC" -> sortRequest = Sort.by("title").descending();
                case "NAME_ASC" -> sortRequest = Sort.by("title").ascending();
                default -> sortRequest = Sort.unsorted();
            }
        }

        Iterable<ReadTournamentDto> list = tournamentService.getTournamentList(
                        Optional.ofNullable(category),
                        Optional.ofNullable(filterRequest),
                        sortRequest).stream()
                .map(r -> mapper.map(r, ReadTournamentDto.class)).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{tournamentId}")
    public ResponseEntity<ReadTournamentDto> getTournamentById(@PathVariable Long tournamentId) {
        ReadTournamentDto tournament = mapper.map(tournamentService.getTournament(tournamentId), ReadTournamentDto.class);

        return ResponseEntity.ok(tournament);
    }


    @PostMapping
    public ResponseEntity<ReadTournamentDto> createTournament(@RequestBody WriteTournamentDto tournamentToCreate) {
        ReadTournamentDto createdTournament = mapper.map(
                tournamentService.createTournament(mapper.map(tournamentToCreate, Tournament.class)),
                ReadTournamentDto.class
        );

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTournament.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(createdTournament);
    }

    @PutMapping("/{tournamentId}")
    public ResponseEntity<ReadTournamentDto> updateTournament(
            @PathVariable Long tournamentId,
            @RequestBody WriteTournamentDto tournamentToUpdate) {

        ReadTournamentDto updatedTournament = mapper.map(
                tournamentService.replaceTournament(tournamentId, mapper.map(tournamentToUpdate, Tournament.class)),
                ReadTournamentDto.class
        );

        return ResponseEntity.ok(updatedTournament);
    }

    @DeleteMapping("/{tournamentId}")
    public ResponseEntity<Void> deleteTournamentById(@PathVariable Long tournamentId) {
        tournamentService.deleteTournament(tournamentId);
        return ResponseEntity.noContent().build();
    }

}