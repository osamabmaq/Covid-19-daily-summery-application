package com.osama.covid19summaryapp.dto;

public class CountrySummary extends AbstractVirusSummary {
    private final String countryName;

    public CountrySummary(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public String toString() {
        return "country : " + getCountryName()+", "+super.toString();
    }
}
