package com.osama.covid19summaryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@PropertySources(
        {
                @PropertySource("classpath:properties files/app-specific.properties")
        }
)
public class AppMainClass {
    public static void main(String[] args) {
        SpringApplication.run(AppMainClass.class, args);
    }
}