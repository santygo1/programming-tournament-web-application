package ru.danilspirin.backend.dto.task;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReadTaskDto {

    Long id;
    String title;
    String taskCondition;
    ReadTaskDto taskDto;
}