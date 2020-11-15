package com.elabo8.catfact.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fact {
    @JsonProperty("_id")
    private String id;
    private String text;
    private String type;
    private User user;
    private Long upvotes;
    private Object userUpvoted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Long upvotes) {
        this.upvotes = upvotes;
    }

    public Object getUserUpvoted() {
        return userUpvoted;
    }

    public void setUserUpvoted(Object userUpvoted) {
        this.userUpvoted = userUpvoted;
    }
}
