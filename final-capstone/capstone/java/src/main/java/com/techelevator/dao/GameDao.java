package com.techelevator.dao;

import com.techelevator.model.Game;

import java.security.Principal;
import java.util.Date;
import java.util.List;

public interface GameDao {
    List<Game> list();
    Game get(int gameId);

    Game create(String gameName, String organizerName, String endDate);

    Game update(Game game, int gameId);

    List<Game> searchByUsername(String username);
    String getUsername (Principal principal);

    int delete(int id);

}
