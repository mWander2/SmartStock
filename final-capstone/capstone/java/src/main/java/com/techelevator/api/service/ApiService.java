package com.techelevator.api.service;

import com.techelevator.api.model.ApiModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Component
public class ApiService {

    @Value("${polygon.api.url}")
    private String apiUrl;

    @Value("${polygon.api.key}")
    private String apiKey;

    public List<ApiModel> getSearchResults(String searchString) {

        String url = apiUrl + "&limit=10&q=" + searchString;
        System.out.println(url);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);

        HttpEntity<String> httpEntity = new HttpEntity<>("", headers);
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        JsonNode jsonNode;
        List<ApiModel> apiList = new ArrayList<>();

        try {
            jsonNode = objectMapper.readTree(response.getBody());
            JsonNode root = jsonNode.path("results");

            for (int i=0; i < root.size(); i++) {
                double closePrice = root.path(i).path("c").asDouble();
                int transactions = root.path(i).path("n").asInt();
                String status = root.path(i).path("status").asText();
                String ticker = root.path(i).path("ticker").asText();

                ApiModel apiModel = new ApiModel(closePrice, transactions, status, ticker);
                apiList.add(apiModel);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return apiList;
    }
}
