package com.springBootLearning.spring_boot_0_1.Config;


import com.springBootLearning.spring_boot_0_1.Auth.AuditorAvailImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditorAvail" )
public class AppConfig {

    @Bean
    ModelMapper getModelMapper(){
    return new ModelMapper();
    }

    @Bean
    AuditorAware<String> getAuditorAvail(){
        return new AuditorAvailImpl();
    }

}
