package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExRateData {
    private String result;
    private Map<String, Double> rates;

    public String getResult() {
        return result;
    }

    public Map<String, Double> getRates() {
        return rates;
    }
}