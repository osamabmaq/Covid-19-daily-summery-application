package com.example.Covid19.infection.tracker.services;

import com.example.Covid19.infection.tracker.component.JSONObjectVirusSummaryConverter;
import com.example.Covid19.infection.tracker.component.SummaryDownloader;
import com.example.Covid19.infection.tracker.dto.CountrySummary;
import com.example.Covid19.infection.tracker.dto.GlobalSummary;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VirusSummaryProvider {
    private final SummaryDownloader summaryDownloader;
    private final JSONObjectVirusSummaryConverter jsonObjectVirusSummaryConverter;

    private GlobalSummary globalSummary;
    private List<CountrySummary> countriesSummaryList;

    private JSONParser parser = new JSONParser();

    @Autowired
    public VirusSummaryProvider(SummaryDownloader summaryDownloader,
                                JSONObjectVirusSummaryConverter jsonObjectVirusSummaryConverter) {
        this.summaryDownloader = summaryDownloader;
        this.jsonObjectVirusSummaryConverter = jsonObjectVirusSummaryConverter;
    }

    @Scheduled(fixedDelay = 1000 * 60 * 5)
    public void updateData() throws ParseException {
        JSONObject virusSummaryJSONObject = getVirusSummaryJSONObject();
        updateGlobalSummary((JSONObject) virusSummaryJSONObject.get("Global"));
        updateCountriesSummaryList((JSONArray) virusSummaryJSONObject.get("Countries"));
    }

    private JSONObject getVirusSummaryJSONObject() throws ParseException {
        String virusSummary = summaryDownloader.downloadVirusSummary();
        return (JSONObject) parser.parse(virusSummary);
    }

    private void updateGlobalSummary(JSONObject globalSummaryJSONObject) {
        globalSummary = jsonObjectVirusSummaryConverter.convertToGlobalSummary(globalSummaryJSONObject);
    }

    private void updateCountriesSummaryList(JSONArray countriesSummaryJSONObject) {
        countriesSummaryList = new ArrayList<>();
        for (Object obj : countriesSummaryJSONObject) {
            JSONObject countrySummary = (JSONObject) obj;
            if (isEnemy(countrySummary))
                continue;
            countriesSummaryList.add(
                    jsonObjectVirusSummaryConverter.convertToCountrySummary(countrySummary));
        }
    }

    private boolean isEnemy(JSONObject countrySummary) {
        return countrySummary.get("Country").toString().equals("Israel");
    }

    public GlobalSummary getGlobalSummary() {
        return globalSummary;
    }

    public List<CountrySummary> getCountiesSummaryList() {
        return countriesSummaryList;
    }
}