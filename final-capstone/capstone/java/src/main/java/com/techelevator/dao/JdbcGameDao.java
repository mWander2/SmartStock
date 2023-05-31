package com.techelevator.dao;

import com.techelevator.model.Game;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JdbcGameDao implements GameDao {
    private static List<Game> games = new ArrayList<>();


    private JdbcTemplate jdbcTemplate;
    private Game mapRowToGame(SqlRowSet rs){
        Game game = new Game();
        game.setGameId(rs.getInt("game_id"));
        game.setGameName(rs.getString("game_name"));
        game.setEndDate(rs.getDate("end_date"));
        game.setOrganizerId(rs.getInt("organizer_id"));
        return game;
    }

    public JdbcGameDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Game> list() {
        String sql = "SELECT * " +
                "FROM games g ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Game game = mapRowToGame(results);
            games.add(game);
        }
        return games;
    }

    @Override
    public Game get(int gameId) {
      String sql = "SELECT * " +
              "FROM games g " +
              "WHERE g.game_id = ?";
      SqlRowSet result = jdbcTemplate.queryForRowSet(sql, gameId);
      if(result.next()){
          return mapRowToGame(result);
      }else {
          return null;
      }
    }

    @Override
    public Game create(String gameName, int organizerId, Date endDate) {
        String sql = "INSERT INTO games (game_name, organizer_id, end_date) " +
                "VALUES (?, ?, ?) " +
                "RETURNING game_id, game_name, organizer_id, end_date";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, gameName, organizerId, endDate);

        if (result.next()){
            Game game = mapRowToGame(result);
            return game;
        }else{
            return null;
        }

    }

    @Override
    public Game update(Game game, int gameId) {
        Game updatedGame = null;
    String sql = "UPDATE games " +
            "SET game_name = ?, organizer_id = ?, end_date = ? " +
            "WHERE game_id = ?";

       int rowsAffected =  jdbcTemplate.update(sql, game.getGameName(),
                game.getOrganizerId(), game.getEndDate(), gameId);
        updatedGame = get(game.getGameId());
        if(rowsAffected > 0) {
            return updatedGame;
        }
        else{
            return null;
        }
    }

    @Override
    public int delete(int gameId) {
        int numRowsDeleted = 0;
        String sql0 = "DELETE FROM user_game WHERE game_id = ?";
        String sql1 = "DELETE FROM games WHERE game_id = ?";

        jdbcTemplate.update(sql0, gameId);
        numRowsDeleted = jdbcTemplate.update(sql1, gameId);

        return numRowsDeleted;
    }



}
