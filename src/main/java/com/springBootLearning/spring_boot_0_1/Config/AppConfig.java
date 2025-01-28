package com.springBootLearning.spring_boot_0_1.Config;


import com.springBootLearning.spring_boot_0_1.Auth.AuditorAvailImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
