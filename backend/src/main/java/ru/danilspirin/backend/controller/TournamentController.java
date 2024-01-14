package ru.danilspirin.backend.controller;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.danilspirin.backend.dto.tournament.ReadTournamentDto;
import ru.danilspirin.backend.dto.tournament.WriteTournamentDto;
import ru.danilspirin.backend.model.Tournament;
import ru.danilspirin.backend.service.tournament.TournamentService;

import java.net.URI;

@RestController
@RequestMapping("/tournaments")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TournamentController {

    final TournamentService tournamentService;
    final ModelMapper mapper;

    public TournamentController(TournamentService tournamentService, ModelMapper mapper) {
        this.tournamentService = tournamentService;
        this.mapper = mapper;
    }


    @GetMapping
    public ResponseEntity<Iterable<ReadTournamentDto>> getTournamentList() {
        Iterable<ReadTournamentDto> list = tournamentService.getTournamentList().stream()
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