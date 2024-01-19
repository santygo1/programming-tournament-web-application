package ru.danilspirin.backend.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.ui.Model;
import ru.danilspirin.backend.dto.task.ReadTaskDto;
import ru.danilspirin.backend.model.Task;

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
}
