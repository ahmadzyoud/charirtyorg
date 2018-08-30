package com.zyoud.charirtyorg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.zyoud.charirtyorg.controller")
@EntityScan({"com.zyoud.charirtyorg.domain", "com.zyoud.charirtyorg.domain.enumeration"})

@EnableJpaRepositories("com.zyoud.charirtyorg.repository")
@ComponentScan("com.zyoud.charirtyorg.service")
@ComponentScan("com.zyoud.charirtyorg.service.impl")
public class CharirtyorgApplication {

    public static void main(String[] args) {

        SpringApplication.run(CharirtyorgApplication.class, args);
    }
}
