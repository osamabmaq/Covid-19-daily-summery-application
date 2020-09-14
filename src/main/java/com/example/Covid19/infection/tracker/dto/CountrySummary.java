package com.example.Covid19.infection.tracker.dto;

public class CountrySummary extends AbstractVirusSummary{
    private final String countryName;

    public CountrySummary(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }
}
