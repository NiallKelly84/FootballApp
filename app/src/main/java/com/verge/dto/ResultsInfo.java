package com.verge.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by eniakel on 22/06/2015.
 */
public class ResultsInfo {
    private Long id;

    @NotNull
    private String matchDate;

    @NotNull
    private String teamA;

    @NotNull
    private String teamB;

    @NotNull
    private String halfTime;

    @NotNull
    private String fullTime;

    public ResultsInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public String getHalfTime() {
        return halfTime;
    }

    public void setHalfTime(String halfTime) {
        this.halfTime = halfTime;
    }

    public String getFullTime() {
        return fullTime;
    }

    public void setFullTime(String fullTime) {
        this.fullTime = fullTime;
    }
}
