package com.techelevator.dao;

import com.techelevator.model.Game;

import java.util.Date;
import java.util.List;

public interface GameDao {
    List<Game> list();
    Game get(int gameId);

    Game create(String gameName, int organizerId, Date endDate);

    Game update(Game game, int gameId);

    int delete(int id);
}
