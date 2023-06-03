package com.techelevator.controller;

import com.techelevator.api.model.StockModel;
import com.techelevator.dao.PortfolioDao;
import com.techelevator.model.Portfolio;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/portfolios")
@PreAuthorize("isAuthenticated()")
public class PortfolioController {
    private PortfolioDao portfolioDao;

    public PortfolioController(PortfolioDao portfolioDao) {
        this.portfolioDao = portfolioDao;
    }

    @GetMapping
    public List<Portfolio> getAllPortfolios() {
        return portfolioDao.getAllPortfolios();
    }

    @GetMapping("/{portfolioId}")
    public Portfolio getPortfolioById(@PathVariable int portfolioId) {
        return portfolioDao.getByPortfolioId(portfolioId);
    }

    @GetMapping("/game/{gameId}")
    public List<Portfolio> getPortfoliosByGameId(@PathVariable int gameId) {
        return portfolioDao.getByGameId(gameId);
    }

    @GetMapping("/user/{userId}")
    public List<Portfolio> getPortfoliosByUserId(@PathVariable int userId) {
        return portfolioDao.getByUserId(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Portfolio createPortfolio(@RequestBody Portfolio portfolio) {
        int gameId = portfolio.getGameId();
        int userId = portfolio.getUserId();
        List<StockModel> stocks = portfolio.getStocks();
        BigDecimal cashBalance = portfolio.getCashBalance();

        return portfolioDao.create(gameId, userId, stocks, cashBalance);
    }

    @PutMapping("/buy/{gameId}/{userId}")
    public Portfolio updateBuyPortfolio(@RequestBody Portfolio portfolio, @PathVariable int gameId, @PathVariable int userId) {
        return portfolioDao.updateBuy(portfolio, gameId, userId);
    }

    @PutMapping("/sell/{gameId}/{userId}")
    public Portfolio updateSellPortfolio(@RequestBody Portfolio portfolio, @PathVariable int gameId, @PathVariable int userId) {
        return portfolioDao.updateSell(portfolio, gameId, userId);
    }


    @DeleteMapping("/{gameId}/{userId}")
    public int deletePortfolio(@PathVariable int gameId, @PathVariable int userId) {
        return portfolioDao.delete(gameId, userId);
    }
}



