package com.elabo8.catfact.demo.service;

import com.elabo8.catfact.demo.domain.Fact;
import com.elabo8.catfact.demo.domain.Facts;
import com.elabo8.catfact.demo.dto.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Service
public class CatFactService {

    @Value("${api.url}")
    private String url;

    private RestTemplate restTemplate = new RestTemplate();

    public Map<String, Long> findUsers() {
        Map<String, Long> userMap = new HashMap<>();
        List<Fact> allFacts = restTemplate.getForEntity(url + "/facts", Facts.class).getBody().getFacts();
        for (Fact fact : allFacts) {
            if (fact == null || fact.getUser() == null || fact.getUser().getFullName() == null) {
                System.out.println(" >>> " + (fact == null ? "Fact is null" : fact.getUser() == null ? "User is null. Fact ID: " + fact.getId() : "First or Last is null. User ID: " + fact.getUser().getId()));
            } else {
                if (userMap.containsKey(fact.getUser().getFullName())) {
                    Long totalVotes = userMap.get(fact.getUser().getFullName()) + fact.getUpvotes();
                    userMap.put(fact.getUser().getFullName(), totalVotes);
                } else {
                    userMap.put(fact.getUser().getFullName(), fact.getUpvotes());
                }
            }
        }
        return userMap;
    }

    public List<Result> sortUsers(Map<String, Long> userMap) {
        List<Map.Entry<String, Long>> list = new ArrayList<>(userMap.entrySet());
        list.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
        List<Result> results = new ArrayList<>();
        for (Map.Entry<String, Long> entry : list) {
            results.add(new Result(entry.getKey(), entry.getValue()));
        }
        return results;
    }


    public String createCSVFile(List<Result> results) {
        File outputFile = new File("Result.csv");
        try {
            ICsvBeanWriter csvWriter = new CsvBeanWriter(new PrintWriter(outputFile), CsvPreference.STANDARD_PREFERENCE);
            String[] csvHeader = {"Full Name", "Total Votes"};
            String[] nameMapping = {"userName", "totalVotes"};

            csvWriter.writeHeader(csvHeader);

            for (Result result : results) {
                csvWriter.write(result, nameMapping);
            }
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputFile.getAbsolutePath();
    }
}
