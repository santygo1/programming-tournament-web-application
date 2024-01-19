package ru.danilspirin.backend.dto.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.danilspirin.backend.dto.test.ReadTestDto;
import ru.danilspirin.backend.model.records.Category;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReadTaskDto {

    Long id;
    String title;

    @JsonProperty("text")
    String taskCondition;

    Category category;

    int timeRequirementsInMinutes;
    int memoryRequirementsInMb;

    String inputDataFormat;
    String outputDataFormat;
    
    Long authorId;

    List<ReadTestDto> tests;
}