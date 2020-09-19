package com.osama.covid19summaryapp.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class SummaryDownloader {
    @Value("${rest.api.url}")
    private String REST_API_URL;

    public String downloadVirusSummary() {
        HttpRequest request = HttpRequest.newBuilder(URI.create(REST_API_URL)).build();
        try {
            return HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString())
                    .body();
        } catch (IOException | InterruptedException e) {
            throw new SummaryDownloadException(e);
        }
    }

    private class SummaryDownloadException extends RuntimeException {
        public SummaryDownloadException(Exception e) {
            super(e + " was thrown during fetching summary");
        }
    }
}