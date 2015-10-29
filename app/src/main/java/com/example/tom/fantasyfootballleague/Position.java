package com.example.tom.fantasyfootballleague;

/**
 * Created by Dustin on 10/28/2015.
 */


public class Position {
    private int id;
    private String name;

    public Position(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
