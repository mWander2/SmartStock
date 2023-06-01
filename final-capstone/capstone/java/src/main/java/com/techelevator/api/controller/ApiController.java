package com.techelevator.api.controller;

import com.techelevator.api.model.ApiModel;
import com.techelevator.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    ApiService apiService = new ApiService();

    @RequestMapping(path="/search", method=RequestMethod.GET)
    public List<ApiModel> search(@RequestParam String query) {

        return apiService.getSearchResults(query);

    }
}
