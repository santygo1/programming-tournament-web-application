package ru.danilspirin.backend.dto.tournament;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.danilspirin.backend.model.records.Category;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WriteTournamentDto {

    String text;
    String title;
    LocalDateTime startDate;
    LocalDateTime finishDate;
    Category category;
    List<Long> tasks;
}