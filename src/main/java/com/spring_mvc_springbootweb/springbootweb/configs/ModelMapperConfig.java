package com.spring_mvc_springbootweb.springbootweb.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}

//Prevent null overwrite — this is industry-level fix:
//@Configuration
//public class MapperConfig {
//
//    @Bean
//    public ModelMapper modelMapper() {
//        ModelMapper mapper = new ModelMapper();
//
//        mapper.getConfiguration()
//                .setSkipNullEnabled(true); // 🔥 critical
//
//        return mapper;
//    }
//}
