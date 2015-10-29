package com.example.tom.fantasyfootballleague;

/**
 * Created by Dustin on 10/28/2015.
 */

//TODO Implement code with private variables for each row in the table
//TODO create getters and setters for each variable
public class Player {

    private int id;
    private String name;
    private int nflTeamId;
    private int positionId;
    private int teamId;

    public Player(String name, int nflTeamId, int positionId, int teamId) {
        this.name = name;
        this.nflTeamId = nflTeamId;
        this.positionId = positionId;
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNflTeamId() {
        return nflTeamId;
    }

    public void setNflTeamId(int nflTeamId) {
        this.nflTeamId = nflTeamId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}
