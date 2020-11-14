package com.elabo8.catfact.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Fact {
    @JsonProperty("all")
    private List<All> all = null;

    public List<All> getAll() {
        return all;
    }

    public void setAll(List<All> all) {
        this.all = all;
    }
}
