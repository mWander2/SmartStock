package com.techelevator.model;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class Game {
    private int gameId;
    @NotBlank(message = "The field `gameName` should not be blank.")
    private String gameName;
    private String organizerName;
    @NotBlank(message="The field `endDate` should not be blank.")
    private String endDate;

    public Game() {
    }

    public Game(String gameName, String organizerName, String endDate) {
        this.gameName = gameName;
        this.organizerName = organizerName;
        this.endDate = endDate;
    }

    public Game(int gameId, String gameName, String organizerName, String endDate) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.organizerName = organizerName;
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

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Game{" + "gameId=" + gameId + ", gameName='" + gameName + '\''
                + ", organizerName='" + organizerName + '\'' + ", endDate=" + endDate + '}';
    }
}





