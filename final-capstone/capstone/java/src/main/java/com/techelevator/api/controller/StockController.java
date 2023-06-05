package com.techelevator.api.controller;

import com.techelevator.api.model.ResultsModel;
import com.techelevator.api.model.StockModel;
import com.techelevator.api.service.ResultsService;
import com.techelevator.api.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class StockController {

    @Autowired
    StockService stockService;
    @Autowired
    ResultsService resultsService;

//    @GetMapping("/stock")
//    public ResponseEntity<?> search(@RequestParam(required = false) String ticker) {
//        if (ticker == null || ticker.isEmpty()) {
//            return ResponseEntity.badRequest().body("Ticker parameter is missing");
//        }
//
//        StockModel stockModel = stockService.getSearchResults(ticker);
//
//        if (stockModel == null || stockModel.getResults().isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        return ResponseEntity.ok(stockModel);
//    }
//
//    @GetMapping("/results")
//    public ResponseEntity<?> results(@RequestParam(required = false) String ticker) {
//        if (ticker == null || ticker.isEmpty()) {
//            return ResponseEntity.badRequest().body("Ticker parameter is missing");
//        }
//
//        List<ResultsModel> resultsList = resultsService.getSearchResults(ticker);
//
//        if (resultsList == null || resultsList.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        return ResponseEntity.ok(resultsList);
//    }

    @GetMapping("/resultsObject")
    public ResponseEntity<?> getResultObject(@RequestParam(required = false) String ticker) {
        if (ticker == null || ticker.isEmpty()) {
            return ResponseEntity.badRequest().body("Ticker parameter is missing");
        }
        ResultsModel resultsModel = resultsService.getResultObject(ticker);
        if (resultsModel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultsModel);
    }
}

// postman url: http://localhost:9000/stock?ticker={ticker}

