package com.techelevator.model;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class Game {
    private int gameId;
    @NotBlank(message = "The field `gameName` should not be blank.")
    private String gameName;
    private int organizerId;
    @NotBlank(message="The field `endDate` should not be blank.")
    private Date endDate;

    public Game() {
    }

    public Game(String gameName, int organizerId, Date endDate) {
        this.gameName = gameName;
        this.organizerId = organizerId;
        this.endDate = endDate;
    }

    public Game(int gameId, String gameName, int organizerId, Date endDate) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.organizerId = organizerId;
        this.endDate = endDate;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(int organizerId) {
        this.organizerId = organizerId;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Game{" + "gameId=" + gameId + ", gameName='" + gameName + '\''
                + ", organizerId='" + organizerId + '\'' + ", endDate=" + endDate + '}';
    }
}





