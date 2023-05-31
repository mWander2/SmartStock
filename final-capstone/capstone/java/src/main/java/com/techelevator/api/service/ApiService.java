package com.techelevator.api.service;

import com.techelevator.api.model.ApiModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
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

        String url = apiUrl + apiKey + "&limit=10&q=" + searchString;
        System.out.println(url);

        HttpEntity<String> httpEntity = new HttpEntity<>("");
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        JsonNode jsonNode;
        List<ApiModel> apiList = new ArrayList<ApiModel>();

        try {
            jsonNode = objectMapper.readTree(response.getBody());

            JsonNode root = jsonNode.path("data");

            for (int i = 0; i < root.size(); i++) {
                int closePrice = root.path(i).path("closePrice").asInt();
                int highPrice = root.path(i).path("highPrice").asInt();
                int lowPrice = root.path(i).path("lowPrice").asInt();
                int openPrice = root.path(i).path("openPrice").asInt();
                int timeStamp = root.path(i).path("timeStamp").asInt();
                int volume = root.path(i).path("volume").asInt();
                String ticker = root.path(i).path("ticker").asText();
                Boolean isAdjusted = root.path(i).path("isAdjusted").asBoolean();
                int queryCount = root.path(i).path("queryCount").asInt();
                String requestId = root.path(i).path("requestId").asText();
                int resultsCount = root.path(i).path("resultsCount").asInt();
                String status = root.path(i).path("status").asText();

                ApiModel apiModel = new ApiModel(closePrice, highPrice, lowPrice, openPrice, timeStamp, volume,
                        ticker, isAdjusted, queryCount, requestId, resultsCount, status);
                apiList.add(apiModel);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return apiList;
    }
}

