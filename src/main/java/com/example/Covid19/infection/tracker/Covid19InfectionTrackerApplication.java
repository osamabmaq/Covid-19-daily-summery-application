package com.example.Covid19.infection.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Covid19InfectionTrackerApplication {
	public static void main(String[] args) {
		SpringApplication.run(Covid19InfectionTrackerApplication.class, args);
	}
}