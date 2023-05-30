package com.techelevator.dao;

import com.techelevator.model.Game;

import java.util.List;

public interface GameDao {
    List<Game> list();
    Game get(int gameId);
    Game create(Game game);
    Game update(Game game, int id);
    void delete(int id);
}
