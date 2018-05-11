package com.airline.app.config;

import com.airline.app.entities.AbstractAircraft;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(AbstractAircraft.class, new AircraftDeserializer());
        return new ObjectMapper().registerModules(module);
    }
}