package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootApp {
    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(SpringBootApp.class, args);
    }
}
