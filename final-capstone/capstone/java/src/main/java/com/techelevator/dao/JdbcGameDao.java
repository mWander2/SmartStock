package com.techelevator.dao;

import com.techelevator.model.Game;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JdbcGameDao implements GameDao {

    private JdbcTemplate jdbcTemplate;
    private Game mapRowToGame(SqlRowSet rs){
        Game game = new Game();
        game.setGameId(rs.getInt("game_id"));
        game.setGameName(rs.getString("game_name"));
        game.setEndDate(rs.getString("end_date"));
        game.setOrganizerName(rs.getString("organizer_name"));
        return game;
    }

    public JdbcGameDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Game> list() {
        List<Game> games = new ArrayList<>();

        String sql = "SELECT * " +
                "FROM game g ";
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
              "FROM game g " +
              "WHERE g.game_id = ?";
      SqlRowSet result = jdbcTemplate.queryForRowSet(sql, gameId);
      if(result.next()){
          return mapRowToGame(result);
      }else {
          return null;
      }
    }

    @Override
    public Game create(String gameName, String organizerName, String endDate) {
        String sql = "INSERT INTO game (game_name, organizer_name, end_date) " +
                "VALUES (?, ?, ?) " +
                "RETURNING game_id, game_name, organizer_name, end_date";
        String sql1 = "INSERT INTO user_game (game_id, user_id)" +
                "VALUES((SELECT game_id FROM game WHERE game_name = ?), " +
                "(SELECT user_id FROM user WHERE username = ?))";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, gameName, organizerName, endDate);
        jdbcTemplate.queryForRowSet(sql1, gameName, organizerName);
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
    String sql = "UPDATE game " +
            "SET game_name = ?, organizer_name = ?, end_date = ? " +
            "WHERE game_id = ?";

       int rowsAffected =  jdbcTemplate.update(sql, game.getGameName(),
                game.getOrganizerName(), game.getEndDate(), gameId);
        updatedGame = get(game.getGameId());
        if(rowsAffected > 0) {
            return updatedGame;
        }
        else{
            return null;
        }
    }

    public String getUsername(Principal principal){
        return principal.getName();
    }


    @Override
    public List<Game> searchByUsername(String username) {
        List<Game> games = new ArrayList<>();

        String sql = "SELECT * " +
                "FROM game g " +
                "JOIN user_game ON g.game_id = user_game.game_id " +
                "JOIN users ON users.user_id = user_game.user_id" +
                "WHERE username = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
        while(results.next()){
            Game game = mapRowToGame(results);
            games.add(game);
        }
        return games;



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
