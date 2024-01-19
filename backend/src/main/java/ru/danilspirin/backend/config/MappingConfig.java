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

@Configuration
public class MappingConfig {

    @Bean
    @Primary
    public ModelMapper mapper(){
        return new ModelMapper();
    }

    @Bean
    public ModelMapper taskModelMapper(){
         var mapper = new ModelMapper();
         mapper.typeMap(Task.class, ReadTaskDto.class)
                .addMappings(mapping -> mapping.map(src -> src.getAuthor().getId(), ReadTaskDto::setAuthorId));

        return mapper;
    }

    @Bean
    public ModelMapper tournamentModelMapper(){
        var mapper = new ModelMapper();
        mapper.typeMap(Tournament.class, ReadTournamentDto.class)
                .addMappings(mapping -> mapping.skip(ReadTournamentDto::setFinished))
                .setPostConverter(context -> {
                    Tournament source = context.getSource();
                    ReadTournamentDto destination = context.getDestination();

                    destination.setFinished((LocalDate.now().isAfter(source.getFinishDate()) || LocalDate.now().isEqual(source.getFinishDate())));

                    return context.getDestination();
                });

        return mapper;
    }
}
