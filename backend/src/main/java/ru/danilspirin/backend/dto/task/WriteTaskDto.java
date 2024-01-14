package ru.danilspirin.backend.dto.task;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WriteTaskDto {

    String title;
    String taskCondition;
}