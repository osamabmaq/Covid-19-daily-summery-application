package com.osama.covid19summaryapp.controllers;

import com.osama.covid19summaryapp.dto.CountrySummary;
import com.osama.covid19summaryapp.dto.GlobalSummary;
import com.osama.covid19summaryapp.services.VirusSummaryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;


@Controller
public class MainController {
    private final VirusSummaryProvider virusSummaryProvider;

    @Autowired
    public MainController(VirusSummaryProvider virusSummaryProvider) {
        this.virusSummaryProvider = virusSummaryProvider;
    }

    @GetMapping("/")
    public String home(@ModelAttribute("global") GlobalSummary globalSummary,
                       @ModelAttribute("countries") List<CountrySummary> countrySummaryList) {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @ModelAttribute("global")
    public GlobalSummary globalSummary() {
        return virusSummaryProvider.getGlobalSummary();
    }

    @ModelAttribute("countries")
    public List<CountrySummary> countrySummaryList() {
        return virusSummaryProvider.getCountiesSummaryList();
    }
}