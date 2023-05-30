package com.techelevator.dao;

import com.techelevator.model.Game;

import java.util.ArrayList;
import java.util.List;

public class JdbcGameDao implements GameDao {
    private static List<Game> games = new ArrayList<>();



    @Override
    public List<Game> list() {
        return games;
    }

    @Override
    public Game get(int gameId) {
        for (Game game : games){
            if (game.getGameId() == gameId){
                return game;
            }
        }
        return null;
    }

    @Override
    public Game create(Game game) {
        game.setGameId(getMaxIdPlusOne());
        games.add(game);
        return game;
    }

    @Override
    public Game update(Game game, int id) {
        Game result = game;
        boolean finished = false;
        List<Game> games = list();

        for (int i = 0; i < games.size(); i++) {
            if(games.get(i).getGameId() == id){
                if(result.getGameId() == 0){
                    result.setGameId(id);
                }
                games.set(i, result);
                finished = true;
                break;
            }
        }
        if(!finished){
            return null;
        }

        return result;
    }

    @Override
    public void delete(int id) {
        Game target = null;
        for (int i = 0; i < games.size(); i++) {
            if(games.get(i).getGameId() == id){
                target = games.get(i);
            }
        }
        games.remove(target);
    }


    private int getMaxId() {
        int maxId = 0;
        for (int i = 0; i < games.size(); i++) {
            if(games.get(i).getGameId() > maxId ){
                maxId = games.get(i).getGameId();
            }
        }
        return maxId;
    }

    private int getMaxIdPlusOne() {
        return getMaxId() + 1;
    }

}
