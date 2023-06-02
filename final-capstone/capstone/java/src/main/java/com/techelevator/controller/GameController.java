package com.techelevator.controller;


import com.techelevator.dao.GameDao;
import com.techelevator.dao.JdbcGameDao;
import com.techelevator.model.Game;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/games")
@PreAuthorize("isAuthenticated()")
public class GameController {
    private GameDao dao;

    public GameController(GameDao gameDao){
        this.dao = gameDao;
    }


    @RequestMapping(path = "", method = RequestMethod.GET)
//    @PreAuthorize()
    public List<Game> getAllGames(){
        return dao.list();
    }

    @RequestMapping(path = "/username", method = RequestMethod.GET)
    public List<Game> showMyGames(Principal principal){
        List<Game> myGames = dao.searchByUsername(principal.getName());
        if(myGames == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
            return myGames;
        }
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public String getUsername(Principal principal){
        return dao.getUsername(principal);
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
//    @PreAuthorize()
    public Game get(@PathVariable int id){
        Game game = dao.get(id);
        if (game == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game Not Found");
        } else {
            return game;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/new", method = RequestMethod.POST)
//    @PreAuthorize()
    public Game create(@Valid @RequestBody Game game, Principal principal){
        String gameName = game.getGameName();
        String organizerName = principal.getName();
        String endDate = game.getEndDate();
        return dao.create(gameName, organizerName, endDate);
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
//    @PreAuthorize()
    public Game update(@Valid @RequestBody Game game, @PathVariable int id){
        Game updatedGame = dao.update(game, id);
        if(updatedGame == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game Not Found");
        } else {
            return updatedGame;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PreAuthorize()
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        dao.delete(id);
    }

}
