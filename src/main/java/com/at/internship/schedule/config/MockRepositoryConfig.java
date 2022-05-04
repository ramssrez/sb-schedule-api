package com.at.internship.schedule.config;

import com.at.internship.schedule.repository.IAppointmentRepository;
import com.at.internship.schedule.repository.IContactRepository;
import com.at.internship.schedule.repository.impl.MockAppointmentRepositoryImpl;
import com.at.internship.schedule.repository.impl.MockContactRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockRepositoryConfig {
    @Bean
    public IContactRepository mockContactRepository(){
        return new MockContactRepositoryImpl();
    }
    @Bean
    public IAppointmentRepository mockAppointmentRepository(){
        return new MockAppointmentRepositoryImpl();
    }
}
