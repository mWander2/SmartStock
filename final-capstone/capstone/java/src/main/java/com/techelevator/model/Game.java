package com.techelevator.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

public class Game {
    private int gameId;
    @NotBlank(message = "The field `gameName` should not be blank.")
    private String gameName;
    @NotBlank(message = "The field `organizer` should not be blank.")
    private User organizer;
    @NotBlank(message="The field `endDate` should not be blank.")
    private Date endDate;

    public Game() {
    }

    public Game(String gameName, User organizer, Date endDate) {
        this.gameName = gameName;
        this.organizer = organizer;
        this.endDate = endDate;
    }

    public Game(int gameId, String gameName, User organizer, Date endDate) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.organizer = organizer;
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

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
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
                + ", organizer='" + organizer + '\'' + ", endDate=" + endDate + '}';
    }
}





