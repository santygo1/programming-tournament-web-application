package ru.danilspirin.backend.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.ui.Model;
import ru.danilspirin.backend.dto.task.ReadTaskDto;
import ru.danilspirin.backend.dto.tournament.ReadTournamentDto;
import ru.danilspirin.backend.model.Task;
import ru.danilspirin.backend.model.Tournament;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
public class MappingConfig {

    @Bean
    @Primary
    public ModelMapper mapper(){
        return new ModelMapper();
    }

    @Bean
    public ModelMapper tournamentModelMapper(){
        var mapper = new ModelMapper();
        mapper.typeMap(Tournament.class, ReadTournamentDto.class)
                .addMappings(mapping -> mapping.skip(ReadTournamentDto::setFinished))
                .setPostConverter(context -> {
                    Tournament source = context.getSource();
                    ReadTournamentDto destination = context.getDestination();

                    destination.setFinished((LocalDateTime.now().isAfter(source.getFinishDate()) || LocalDateTime.now().isEqual(source.getFinishDate())));

                    return context.getDestination();
                });

        return mapper;
    }
}
