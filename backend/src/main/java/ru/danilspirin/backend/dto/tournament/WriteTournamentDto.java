package ru.danilspirin.backend.dto.tournament;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WriteTournamentDto {

    String title;
    LocalDate date;
}