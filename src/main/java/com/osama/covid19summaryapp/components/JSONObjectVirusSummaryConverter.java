package com.osama.covid19summaryapp.components;


import com.osama.covid19summaryapp.dto.AbstractVirusSummary;
import com.osama.covid19summaryapp.dto.CountrySummary;
import com.osama.covid19summaryapp.dto.GlobalSummary;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

@Component
public class JSONObjectVirusSummaryConverter {
    private final JSONParser jsonParser = new JSONParser();

    public GlobalSummary convertToGlobalSummary(JSONObject globalSummaryJSONObject) {
        GlobalSummary globalSummary = new GlobalSummary();
        setCasesNumbers(globalSummaryJSONObject, globalSummary);
        return globalSummary;
    }

    public CountrySummary convertToCountrySummary(JSONObject countrySummaryJSONObject) {
        CountrySummary countrySummary = new CountrySummary(countrySummaryJSONObject.get("Country").toString());
        setCasesNumbers(countrySummaryJSONObject, countrySummary);
        return countrySummary;
    }

    private void setCasesNumbers(JSONObject summaryJSONObject,
                                 AbstractVirusSummary virusSummary) {
        virusSummary.setTotalConfirmed(toInt(summaryJSONObject.get("TotalConfirmed")));
        virusSummary.setTotalDeaths(toInt(summaryJSONObject.get("TotalDeaths")));
        virusSummary.setTotalRecovered(toInt(summaryJSONObject.get("TotalRecovered")));
    }

    private int toInt(Object obj) {
        return Integer.parseInt(obj.toString());
    }
}