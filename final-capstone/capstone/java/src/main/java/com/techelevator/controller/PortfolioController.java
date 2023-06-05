package com.techelevator.controller;

import com.techelevator.api.model.StockModel;
import com.techelevator.dao.PortfolioDao;
import com.techelevator.model.Portfolio;
import com.techelevator.model.PortfolioStocks;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/portfolios")
@PreAuthorize("isAuthenticated()")
public class PortfolioController {

    private PortfolioDao portfolioDao;
    public PortfolioController(PortfolioDao portfolioDao) {
        this.portfolioDao = portfolioDao;
    }

//    @GetMapping
//    public List<Portfolio> getAllPortfolios() {
//        return portfolioDao.getAllPortfolios();
//    }
//
//    @GetMapping("/{portfolioId}")
//    public Portfolio getPortfolioById(@PathVariable int portfolioId) {
//        return portfolioDao.getByPortfolioId(portfolioId);
//    }
//
//    @GetMapping("/game/{gameId}")
//    public List<Portfolio> getPortfoliosByGameId(@PathVariable int gameId) {
//        return portfolioDao.getByGameId(gameId);
//    }
//
//    @GetMapping("/user/{userId}")
//    public List<Portfolio> getPortfoliosByUserId(@PathVariable int userId) {
//        return portfolioDao.getByUserId(userId);
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Portfolio createPortfolio(@RequestBody Portfolio portfolio) {
//        int gameId = portfolio.getGameId();
//        int userId = portfolio.getUserId();
//        List<StockModel> stocks = portfolio.getStocks();
//        BigDecimal cashBalance = portfolio.getCashBalance();
//
//        return portfolioDao.create(gameId, userId, stocks, cashBalance);
//    }
//
//    @PutMapping("/buy/{gameId}/{userId}")
//    public Portfolio updateBuyPortfolio(@RequestBody Portfolio portfolio, @PathVariable int gameId, @PathVariable int userId) {
//        return portfolioDao.updateBuy(portfolio, gameId, userId);
//    }
//
//    @PutMapping("/sell/{gameId}/{userId}")
//    public Portfolio updateSellPortfolio(@RequestBody Portfolio portfolio, @PathVariable int gameId, @PathVariable int userId) {
//        return portfolioDao.updateSell(portfolio, gameId, userId);
//    }
//
//    @DeleteMapping("/{gameId}/{userId}")
//    public int deletePortfolio(@PathVariable int gameId, @PathVariable int userId) {
//        return portfolioDao.delete(gameId, userId);
//    }




    @GetMapping("/{gameId}")
    public Portfolio getPortfolioByUser(Principal principal, @PathVariable int gameId) {
        String username = principal.getName();
        return portfolioDao.getPortfolioByUser(username, gameId);
    }

    @GetMapping("/stocks/{gameId}")
    public List<PortfolioStocks> getPortfolioStocks(Principal principal, @PathVariable int gameId) {
        String username = principal.getName();
        return portfolioDao.getPortfolioStocks(username, gameId);
    }

    @PostMapping("/stocks/buy/{cost}/{gameId}")
    public void buy(@RequestBody PortfolioStocks stock, @PathVariable BigDecimal cost, @PathVariable int gameId, Principal principal) {
        String username = principal.getName();
        portfolioDao.buy(stock, cost, username, gameId);
    }

    @DeleteMapping("/stocks/sell/{cost}/{gameId}/{stockId}")
    public void sell(@PathVariable BigDecimal cost, @PathVariable int gameId, @PathVariable int stockId, Principal principal) {
        String username = principal.getName();
        portfolioDao.sell(cost, username, gameId, stockId);
    }
}



