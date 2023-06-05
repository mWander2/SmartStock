package com.techelevator.dao;

import com.techelevator.api.model.StockModel;
import com.techelevator.model.Portfolio;
import com.techelevator.model.PortfolioStocks;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JdbcPortfolioDao implements PortfolioDao {

    private JdbcTemplate jdbcTemplate;
    public JdbcPortfolioDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

//    private List<StockModel> mapStocks(SqlRowSet rs) {
//        List<StockModel> stocks = new ArrayList<>();
//        while(rs.next()){
//            StockModel stock = new StockModel();
//            stock.setTicker(rs.getString("ticker"));
//            stocks.add(stock);
//        }
//        return stocks;
//    }

    private Portfolio mapRowToPortfolio(SqlRowSet rs){
        Portfolio portfolio = new Portfolio();
        portfolio.setPortfolioId(rs.getInt("portfolio_id"));
        portfolio.setGameId(rs.getInt("game_id"));
        portfolio.setUserId(rs.getInt("user_id"));
        portfolio.setCashBalance(rs.getBigDecimal("cash_balance"));
//        portfolio.setStocks(mapStocks(rs));
        return portfolio;
    }


//    @Override
//    public List<Portfolio> getAllPortfolios() {
//        List<Portfolio> portfolios = new ArrayList<>();
//        String sql = "SELECT * FROM portfolio";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
//        while(results.next()){
//            Portfolio portfolio = mapRowToPortfolio(results);
//            portfolios.add(portfolio);
//        }
//        return portfolios;
//    }
//
//    @Override
//    public Portfolio getByPortfolioId(int portfolioId) {
//        Portfolio portfolio = null;
//
//        String sql = "SELECT * FROM portfolio WHERE portfolio_id = ?";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, portfolioId);
//
//        if(results.next()){
//            portfolio = mapRowToPortfolio(results);
//        }
//        return portfolio;
//    }
//
//    @Override
//    public Portfolio getPortfolio(int gameId, int userId) {
//        Portfolio portfolio = null;
//
//        String sql = "SELECT * FROM portfolio WHERE game_id = ? AND user_id = ?";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, gameId, userId);
//
//        if (results.next()) {
//            portfolio = mapRowToPortfolio(results);
//        }
//        return portfolio;
//    }
//
//    @Override
//    public List<Portfolio> getByGameId(int gameId) {
//        List<Portfolio> portfolios = new ArrayList<>();
//
//        String sql = "SELECT * FROM portfolio WHERE game_id = ?";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, gameId);
//
//        if(results.next()){
//            Portfolio portfolio = mapRowToPortfolio(results);
//            portfolios.add(portfolio);
//        }
//        return portfolios;
//    }
//
//    @Override
//    public List<Portfolio> getByUserId(int userId) {
//        List<Portfolio> portfolios = new ArrayList<>();
//
//        String sql = "SELECT * FROM portfolio WHERE user_id = ?";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
//
//        if(results.next()){
//            Portfolio portfolio = mapRowToPortfolio(results);
//            portfolios.add(portfolio);
//        }
//        return portfolios;
//    }
//
//    @Override
//    public Portfolio create(int gameId, int userId, List<StockModel> stocks, BigDecimal cashBalance) {
//        String insertPortfolioSql = "INSERT INTO portfolio (game_id, user_id, cash_balance) " +
//                "VALUES (?, ?, ?) " +
//                "RETURNING portfolio_id";
//        SqlRowSet portfolioResult = jdbcTemplate.queryForRowSet(insertPortfolioSql, gameId, userId, cashBalance);
//
//        if (portfolioResult.next()) {
//            int portfolioId = portfolioResult.getInt("portfolio_id");
//
//            String insertStocksSql = "INSERT INTO portfolio_stocks (portfolio_id, stock_ticker) " +
//                    "VALUES (?, ?)";
//            for (StockModel stock : stocks) {
//                jdbcTemplate.update(insertStocksSql, portfolioId, stock.getTicker());
//            }
//            return getByPortfolioId(portfolioId);
//        }
//        return null;
//    }
//
//    @Override
//    public Portfolio updateBuy(Portfolio portfolio, int gameId, int userId) {
//
//        String updatePortfolioSql = "UPDATE portfolio " +
//                "SET cash_balance = ? " +
//                "WHERE portfolio_id = (SELECT portfolio_id " +
//                "FROM portfolio " +
//                "WHERE game_id = ? AND user_id = ?)";
//        int updatedRows = jdbcTemplate.update(updatePortfolioSql, portfolio.getCashBalance(), gameId, userId);
//
//        if (updatedRows > 0) {
//
//            String insertStocksSql = "INSERT INTO portfolio_stocks (portfolio_id, stock_ticker) " +
//                    "VALUES (?, ?)";
//            for (StockModel stock : portfolio.getStocks()) {
//                jdbcTemplate.update(insertStocksSql, portfolio.getPortfolioId(), stock.getTicker());
//            }
//            return getByPortfolioId(portfolio.getPortfolioId());
//        }
//        return null;
//    }
//    @Override
//    public Portfolio updateSell(Portfolio portfolio, int gameId, int userId) {
//
//        String updatePortfolioSql = "UPDATE portfolio " +
//                "SET cash_balance = ? " +
//                "WHERE portfolio_id = (SELECT portfolio_id " +
//                "FROM portfolio " +
//                "WHERE game_id = ? AND user_id = ?)";
//        int updatedRows = jdbcTemplate.update(updatePortfolioSql, portfolio.getCashBalance(), gameId, userId);
//
//        if (updatedRows > 0) {
//
//            String deleteStocksSql = "DELETE FROM portfolio_stocks " +
//                    "WHERE portfolio_id = (SELECT portfolio_id " +
//                    "FROM portfolio " +
//                    "WHERE game_id = ? AND user_id = ?)";
//            jdbcTemplate.update(deleteStocksSql, gameId, userId);
//
//            return getByPortfolioId(portfolio.getPortfolioId());
//        }
//        return null;
//    }
//
//    @Override
//    public int delete(int gameId, int userId) {
//        return 0;
//    }




    @Override
    public Portfolio getPortfolioByUser(String username, int gameId) {
        Portfolio portfolio = null;
        String sql = "SELECT * FROM portfolio AS p\n" +
                "JOIN users AS u ON p.user_id = u.user_id\n" +
                "WHERE u.username = ? AND p.game_id = ?; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username, gameId);
        if(results.next()) {
            portfolio = mapRowToPortfolio(results);
        }
        return portfolio;
    }

    @Override
    public PortfolioStocks getPortfolioStocksById(int id) {
        PortfolioStocks pS = null;
        String sql = "SELECT * FROM portfolio_stocks WHERE portfolio_stock_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()) {
            pS = mapRowToPortfolioStocks(results);
        }
        return pS;
    }

    @Override
    public List<PortfolioStocks> getPortfolioStocks(String username, int gameId) {
        List<PortfolioStocks> stockList = new ArrayList<>();
        String sql = "SELECT * FROM portfolio_stocks AS ps\n" +
                "JOIN portfolio AS p ON ps.portfolio_id = p.portfolio_id\n" +
                "JOIN users AS u ON p.user_id = u.user_id\n" +
                "WHERE u.username = ? AND p.game_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username, gameId);
        while (results.next()) {
            PortfolioStocks stock = mapRowToPortfolioStocks(results);
            stockList.add(stock);
        }
        return stockList;
    }

    @Override
    public void buy(PortfolioStocks stock, BigDecimal cost, String username, int gameId) {
        String portfolioStockSql = "INSERT INTO portfolio_stocks (portfolio_id, ticker, quantity) \n" +
                "VALUES ((SELECT portfolio_id FROM portfolio AS p\n" +
                "JOIN users AS u ON p.user_id = u.user_id\n" +
                "WHERE u.username = ? AND p.game_id = ?), ?, ?);";
        jdbcTemplate.update(portfolioStockSql, username, gameId, stock.getTicker(), stock.getQuantity());

        BigDecimal currentBalance = getPortfolioByUser(username, gameId).getCashBalance();
        cost = cost.multiply(new BigDecimal(stock.getQuantity()));
        BigDecimal newBalance = currentBalance.subtract(cost);
        String portfolioSql = "UPDATE portfolio SET cash_balance = ?\n" +
                "WHERE game_id = ? AND user_id = (SELECT user_id FROM users WHERE username = ?)";
        jdbcTemplate.update(portfolioSql, newBalance, gameId, username);
    }

    @Override
    public void sell(BigDecimal cost, String username, int gameId, int stockId) {
        int quantity = getPortfolioStocksById(stockId).getQuantity();

        String portfolioStockSql = "DELETE FROM portfolio_stocks WHERE portfolio_stock_id = ?";
        jdbcTemplate.update(portfolioStockSql, stockId);

        BigDecimal currentBalance = getPortfolioByUser(username, gameId).getCashBalance();
        cost = cost.multiply(new BigDecimal(quantity));
        BigDecimal newBalance = currentBalance.add(cost);
        String portfolioSql = "UPDATE portfolio SET cash_balance = ?\n" +
                "WHERE game_id = ? AND user_id = (SELECT user_id FROM users WHERE username = ?)";
        jdbcTemplate.update(portfolioSql, newBalance, gameId, username);
    }

    PortfolioStocks mapRowToPortfolioStocks(SqlRowSet rowSet) {
        PortfolioStocks stock = new PortfolioStocks();
        stock.setId(rowSet.getInt("portfolio_stock_id"));
        stock.setPortfolioId(rowSet.getInt("portfolio_id"));
        stock.setTicker(rowSet.getString("ticker"));
        stock.setQuantity(rowSet.getInt("quantity"));
        return stock;
    }
}
