package com.at.internship.schedule.config;

import com.at.internship.schedule.repository.IAppointmentRepository;
import com.at.internship.schedule.repository.IContactRepository;
import com.at.internship.schedule.repository.impl.CsvAppointmentRepository;
import com.at.internship.schedule.repository.impl.CsvContactRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CsvRepositoryConfig {
    public static final String BEAN_CONTACT_REPOSITORY="csvContactRepository";
    public static final String BEAN_APPOINTMENT_REPOSITORY="csvAppointmentRepository";

    @Bean(name = BEAN_CONTACT_REPOSITORY)
    //@Primary posible solucion
    public IContactRepository csvContactRepository(){
        return CsvContactRepository.getSingleton();
    }

    @Bean(name = BEAN_APPOINTMENT_REPOSITORY)
    public IAppointmentRepository cscAppointmentRepository(){
        return CsvAppointmentRepository.getSingleton();
    }
}
