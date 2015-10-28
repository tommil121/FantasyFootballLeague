package com.example.tom.fantasyfootballleague;

/**
 * Created by Dustin on 10/28/2015.
 */

//TODO Implement code with private variables for each row in the table
//TODO create getters and setters for each variable
public class NFL_Team {
    private int id;
    private String name;
    private String state;

    public NFL_Team(String name, String state) {
        this.name = name;
        this.state = state;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
