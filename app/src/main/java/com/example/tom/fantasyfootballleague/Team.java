package com.example.tom.fantasyfootballleague;

/**
 * Created by Dustin on 10/28/2015.
 */


public class Team {
    private int id;
    private String name;
    private String league;
    private String season;

    public Team(String name, String league, String season) {
        this.name = name;
        this.league = league;
        this.season = season;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
