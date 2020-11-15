package com.elabo8.catfact.demo.dto;

public class Result {
    private String userName;
    private Long totalVotes;

    public Result() {
    }

    public Result(String userName, Long totalVotes) {
        this.userName = userName;
        this.totalVotes = totalVotes;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(Long totalVotes) {
        this.totalVotes = totalVotes;
    }
}
