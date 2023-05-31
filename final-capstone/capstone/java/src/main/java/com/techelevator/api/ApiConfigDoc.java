package com.techelevator.api;

import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

@Component
public class ApiConfigDoc {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ApiConfigDoc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void makeAPIRequest() {
        OkHttpClient httpClient = new OkHttpClient();

        String apiUrl = "https://api.polygon.io/v2/aggs/ticker/AAPL/range/1/day/2023-01-09/2023-01-09?apiKey=M3wol3qZ3ENnOVmxmt3mMD9tSk1hVP84";

        Request request = new Request.Builder()
                .url(apiUrl)
                .build();

        try {
            Response response = httpClient.newCall(request).execute();

            // Check if the response was successful (HTTP 2xx status code)
            ResponseBody responseBody = null;
            if (response.isSuccessful()) {
                responseBody = response.body();
                if (responseBody != null) {
                    String responseString = responseBody.string();
                    // Process the responseString or parse it as JSON
                    System.out.println(responseString);
                }
            } else {
                // Handle non-successful response
                System.out.println("Request failed with response code: " + response.code());
            }


            responseBody.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
