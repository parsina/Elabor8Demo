package com.elabo8.catfact.demo;

import com.elabo8.catfact.demo.dto.Result;
import com.elabo8.catfact.demo.service.CatFactService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class Elabor8DemoTests {

    @Autowired
    private CatFactService service;

    @Test
    void whenFindUsers_thenItIsNotNull() {
        Map<String, Long> users = service.findUsers();
        assertThat(users).isNotNull();
    }

    @Test
    void whenFindUsers_thenItIsNotEmpty() {
        Map<String, Long> users = service.findUsers();
        assertThat(users).isNotEmpty();
    }

    @Test
    void whenSortUsers_thenReturnSortedResults() {
        Map<String, Long> users = new HashMap<>();
        users.put("User 01", 200L);
        users.put("User 02", 500L);
        users.put("User 03", 100L);
        users.put("User 04", 300L);
        users.put("User 05", 900L);
        users.put("User 06", 200L);
        users.put("User 07", 600L);
        users.put("User 08", 800L);
        users.put("User 09", 400L);
        users.put("User 10", 500L);

        List<Result> results = service.sortUsers(users);

        assertThat(results.get(0).getTotalVotes()).isEqualTo(900L);
        assertThat(results.get(9).getTotalVotes()).isEqualTo(100L);
    }

    @Test
    void whenCreateCSVFile_thenReturnCSVFilePath() {
        List<Result> results = new ArrayList<>();
        results.add(new Result("User 01", 214L));
        results.add(new Result("User 02", 180L));
        results.add(new Result("User 03", 89L));
        results.add(new Result("User 04", 67L));
        results.add(new Result("User 05", 34L));

        String path = service.createCSVFile(results);

        assertThat(path).isNotEmpty();
        assertThat(path).contains("\\Result.csv");
    }

}
