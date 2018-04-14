package com.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.test.domain.ConfigurableItem;
import com.test.respository.ConfigurationRepository;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.test.domain"})  // scan JPA entities
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    
    
    
    
}