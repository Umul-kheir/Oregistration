package com.project.registrationonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.project.registrationonline")
public class RegistrationonlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistrationonlineApplication.class, args);
    }
}

