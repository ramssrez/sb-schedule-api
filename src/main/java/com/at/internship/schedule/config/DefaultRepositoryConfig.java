package com.at.internship.schedule.config;

import com.at.internship.schedule.repository.IAppointmentRepository;
import com.at.internship.schedule.repository.IContactRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultRepositoryConfig {
    private final ApplicationContext context;
    public static final String PROP_REPOSITORY_DEFAULT_CONTACT= "${com.at.internship.repository.contact}";
    public static final String PROP_REPOSITORY_DEFAULT_APPOINTMENT = "${com.at.internship.repository.appointment}";

    @Value(PROP_REPOSITORY_DEFAULT_APPOINTMENT)
    private String defaultAppointment;
    @Value(PROP_REPOSITORY_DEFAULT_CONTACT)
    private String defaultContact;


    public DefaultRepositoryConfig(ApplicationContext context) {
        this.context = context;
    }

    @Bean(name = PROP_REPOSITORY_DEFAULT_CONTACT)
    public IContactRepository contactRepository(){
        return (IContactRepository) context.getBean(defaultContact);
    }

    @Bean(name = PROP_REPOSITORY_DEFAULT_APPOINTMENT)
    public IAppointmentRepository appointmentRepository(){
        return (IAppointmentRepository) context.getBean(defaultAppointment);
    }
}
