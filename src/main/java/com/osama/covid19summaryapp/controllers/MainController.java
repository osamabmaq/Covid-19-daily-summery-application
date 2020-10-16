package com.osama.covid19summaryapp.controllers;

import com.osama.covid19summaryapp.services.VirusSummaryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {
    private final VirusSummaryProvider virusSummaryProvider;

    @Autowired
    public MainController(VirusSummaryProvider virusSummaryProvider) {
        this.virusSummaryProvider = virusSummaryProvider;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAllAttributes(getHomePageModelAttributes());
        return "index";
    }

    private Map<String, ?> getHomePageModelAttributes() {
        return Map.of("global", virusSummaryProvider.getGlobalSummary(),
                "countries", virusSummaryProvider.getCountiesSummaryList());
    }
/*
    @GetMapping("/about")
    public String about(){
        return "about";
    }*/
}