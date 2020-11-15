package com.elabo8.catfact.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Facts {
    @JsonProperty("all")
    private List<Fact> facts = null;

    public List<Fact> getFacts() {
        return facts;
    }

    public void setFacts(List<Fact> facts) {
        this.facts = facts;
    }
}
