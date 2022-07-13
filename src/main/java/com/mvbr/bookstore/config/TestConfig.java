package com.mvbr.bookstore.config;

import com.mvbr.bookstore.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Bean
    public void informarProfile() {
        System.out.println("---------------------------------------");
        System.out.println("dev profile");
        System.out.println("---------------------------------------");
    }

    @Autowired
    DBService dbservice;

    @Bean
    public void carregarBaseDeDados() {
        dbservice.carregarBaseDeDados();
    }

}
