package com.elabo8.catfact.demo.controller;

import com.elabo8.catfact.demo.domain.Result;
import com.elabo8.catfact.demo.service.CatFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cat-facts")
public class CatFactController {

    @Autowired
    private CatFactService service;

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity<String> getFacts(){
        // Get users from API
        Map<String, Long> users = service.findUsers();

        // Sort users base on upVotes
        List<Result> results = service.sortUsers(users);

        // Create CSV File and get the file path
        String path = service.createCSVFile(results);

        return new ResponseEntity<>( "CSV File is generated. You can find it at " + path, HttpStatus.OK);
    }
}
