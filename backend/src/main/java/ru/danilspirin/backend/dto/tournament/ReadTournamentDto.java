package ru.danilspirin.backend.dto.tournament;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.danilspirin.backend.model.records.Category;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReadTournamentDto {

    Long id;
    String text;
    String title;
    LocalDateTime startDate;
    LocalDateTime finishDate;
    boolean isFinished;
    Category category;

}