package com.covid.app.CovidApp.Service;

import com.covid.app.CovidApp.utility.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Map;

@Service
public class CovidDataService {

//    public ArrayList<Integer> getCovidData(String countryName){
//
//        Map<String,Object> map=restTemplate.getForObject(Util.COVID_DATA_API, Map.class);
//       // Map<String,Object> cityObjectMap=(Map<String,Object>)map.get("Bihar");
//        //Map<String,Object> districtObjectMap=(Map<String,Object>)cityObjectMap.get("districtData");
//        Map<String,Object> country=(Map<String,Object>)map.get(countryName);
//
//        System.out.println(country);
//        Integer totalCasesText=(Integer) country.get("Total Cases_text");
//        Integer deathsText=(Integer) country.get("Total Deaths_text");
//        Integer recoveredText=(Integer) country.get("Total Recovered_text");
//
//        ArrayList<Integer> res=new ArrayList<>();
//
//        res.add(totalCasesText);res.add(deathsText);res.add(recoveredText);
//        return res;
//    }

    @Autowired
    private RestTemplate restTemplate;

    public  Map<String, Object> getCovidDataForCountry(String countryName) {
        String url = "https://covid-19-tracking.p.rapidapi.com/v1/" + countryName;

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", "bdc16b2d38msh5dac5bb0238e3aap1f3855jsn5ceab79f0f72");
        headers.set("x-rapidapi-host", "covid-19-tracking.p.rapidapi.com");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);

        // Parse and return the data or process it further
        return  (Map<String, Object>) response.getBody();
    }
}
