package com.techelevator.api.controller;

import com.techelevator.api.model.ResultsModel;
import com.techelevator.api.model.StockModel;
import com.techelevator.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    @Autowired
    ApiService apiService;

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(required = false) String ticker) {
        if (ticker == null || ticker.isEmpty()) {
            return ResponseEntity.badRequest().body("Ticker parameter is missing");
        }

        StockModel stockModel = apiService.getSearchResults(ticker);

        if (stockModel == null || stockModel.getResults().isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(stockModel);
    }
}


