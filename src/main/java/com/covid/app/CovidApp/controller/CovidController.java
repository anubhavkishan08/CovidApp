package com.covid.app.CovidApp.controller;

import com.covid.app.CovidApp.Service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CovidController {

    @Autowired
    private CovidDataService covidDataService;

    @GetMapping("/getCountry/{countryName}")
    public  Map<String, Object> getCountryData(@RequestParam("country") String countryName) {

        Map<String, Object> data = covidDataService.getCovidDataForCountry(countryName);
        return data;
    }

}
