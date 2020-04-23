package com.vikingzorros.rehabit.config;

import com.vikingzorros.rehabit.service.AuthService;
import com.vikingzorros.rehabit.service.AuthServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public AuthService authService(){
        return new AuthServiceImpl();
    }
}
