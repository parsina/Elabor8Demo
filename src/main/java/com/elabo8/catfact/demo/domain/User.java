package com.elabo8.catfact.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("_id")
    private String id;
    private Name name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getFullName(){
        return  this.getName().getFirst() + " " + this.getName().getLast();
    }
}
