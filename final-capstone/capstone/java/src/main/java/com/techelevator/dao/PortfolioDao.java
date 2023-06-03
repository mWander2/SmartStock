package com.techelevator.dao;

import com.techelevator.api.model.StockModel;
import com.techelevator.model.Portfolio;

import javax.sound.sampled.Port;
import java.math.BigDecimal;
import java.util.List;

public interface PortfolioDao {
    List<Portfolio> getAllPortfolios();
    Portfolio getByPortfolioId(int portfolioId);
    Portfolio getPortfolio(int gameId, int userId);
    List<Portfolio> getByGameId(int gameId);
    List<Portfolio> getByUserId(int userId);

    Portfolio create(int gameId, int userId, List<StockModel> stocks, BigDecimal cashBalance);
    Portfolio updateBuy(Portfolio portfolio, int gameId, int userId);
    Portfolio updateSell(Portfolio portfolio, int gameId, int userId);

    int delete (int gameId, int userId);
}
