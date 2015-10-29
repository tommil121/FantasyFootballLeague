package com.example.tom.fantasyfootballleague;

/**
 * Created by Dustin on 10/29/2015.
 */
public class League {

    private int leagueId;
    private String name;

    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
