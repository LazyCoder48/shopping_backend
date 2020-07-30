package com.shop.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class MiscConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
