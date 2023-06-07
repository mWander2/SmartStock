package com.techelevator.dao;

import com.techelevator.model.Portfolio;
import com.techelevator.model.PortfolioStocks;

import javax.sound.sampled.Port;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface PortfolioDao {
//    List<Portfolio> getAllPortfolios();
//    Portfolio getByPortfolioId(int portfolioId);
//    Portfolio getPortfolio(int gameId, int userId);
    List<Portfolio> getPortfoliosByGameId(int gameId);
//    List<Portfolio> getByUserId(int userId);
//
//    Portfolio create(int gameId, int userId, List<StockModel> stocks, BigDecimal cashBalance);
//    Portfolio updateBuy(Portfolio portfolio, int gameId, int userId);
//    Portfolio updateSell(Portfolio portfolio, int gameId, int userId);
//
//    int delete (int gameId, int userId);


    Portfolio getPortfolioByUser(String username, int gameId);
    PortfolioStocks getPortfolioStocksById(int id);
    List<PortfolioStocks> getPortfolioStocks(String username, int gameId);
    void buy(PortfolioStocks stock, BigDecimal cost, String username, int gameId);
    void sell(BigDecimal cost, String username, int gameId, int stockId);

    void sellAllStocks(int gameId);

    BigDecimal getCashBalanceByGameAndUser(int gameId, int userId);

    void updateCashBalance(int userId, int gameId, BigDecimal cashBalance);

    Portfolio getPortfolioByGameId(int gameId);

    int getPlayerCount(int gameId);
}
