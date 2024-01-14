package ru.danilspirin.backend.exception.tournament;

public class TournamentNotFoundException extends RuntimeException {

    public TournamentNotFoundException(Long id) {
        super("Tournament with id " + ("'" + id + "'") + " isn't founded.");
    }
}