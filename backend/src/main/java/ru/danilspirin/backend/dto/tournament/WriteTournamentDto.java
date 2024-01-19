package ru.danilspirin.backend.dto.tournament;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.danilspirin.backend.model.records.Category;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WriteTournamentDto {

    String text;
    String title;
    LocalDate startDate;
    LocalDate finishDate;
    Category category;
}