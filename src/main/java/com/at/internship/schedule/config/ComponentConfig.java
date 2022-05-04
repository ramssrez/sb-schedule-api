package com.at.internship.schedule.config;

import com.at.internship.schedule.utils.DateUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComponentConfig {
    @Bean
    public DateUtils dateUtils(){
        return new DateUtils();
    }
}
