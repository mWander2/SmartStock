package com.techelevator.dao;

import com.techelevator.api.model.StockModel;
import com.techelevator.model.Portfolio;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPortfolioDao implements PortfolioDao {
    private JdbcTemplate jdbcTemplate;

    private List<StockModel> mapStocks(SqlRowSet rs) {
        List<StockModel> stocks = new ArrayList<>();
        while(rs.next()){
            StockModel stock = new StockModel();
            stock.setTicker(rs.getString("ticker"));
            stocks.add(stock);
        }
        return stocks;
    }


    private Portfolio mapRowToPortfolio(SqlRowSet rs){
        Portfolio portfolio = new Portfolio();
        portfolio.setPortfolioId(rs.getInt("portfolio_id"));
        portfolio.setGameId(rs.getInt("game_id"));
        portfolio.setUserId(rs.getInt("user_id"));
        portfolio.setCashBalance(rs.getBigDecimal("cash_balance"));
        portfolio.setStocks(mapStocks(rs));
        return portfolio;
    }

    public JdbcPortfolioDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Portfolio> getAllPortfolios() {
        List<Portfolio> portfolios = new ArrayList<>();
        String sql = "SELECT * FROM portfolio";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Portfolio portfolio = mapRowToPortfolio(results);
            portfolios.add(portfolio);
        }

        return portfolios;
    }

    @Override
    public Portfolio getByPortfolioId(int portfolioId) {
        Portfolio portfolio = null;

        String sql = "SELECT * FROM portfolio WHERE portfolio_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, portfolioId);

        if(results.next()){
            portfolio = mapRowToPortfolio(results);
        }

        return portfolio;
    }

    @Override
    public Portfolio getPortfolio(int gameId, int userId) {
        Portfolio portfolio = null;

        String sql = "SELECT * FROM portfolio WHERE game_id = ? AND user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, gameId, userId);

        if (results.next()) {
            portfolio = mapRowToPortfolio(results);
        }


        return portfolio;
    }




    @Override
    public List<Portfolio> getByGameId(int gameId) {
        List<Portfolio> portfolios = new ArrayList<>();

        String sql = "SELECT * FROM portfolio WHERE game_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, gameId);

        if(results.next()){
            Portfolio portfolio = mapRowToPortfolio(results);
            portfolios.add(portfolio);
        }

        return portfolios;
    }

    @Override
    public List<Portfolio> getByUserId(int userId) {
        List<Portfolio> portfolios = new ArrayList<>();

        String sql = "SELECT * FROM portfolio WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        if(results.next()){
            Portfolio portfolio = mapRowToPortfolio(results);
            portfolios.add(portfolio);
        }

        return portfolios;
    }

    @Override
    public Portfolio create(int gameId, int userId, List<StockModel> stocks, BigDecimal cashBalance) {
        String insertPortfolioSql = "INSERT INTO portfolio (game_id, user_id, cash_balance) " +
                "VALUES (?, ?, ?) " +
                "RETURNING portfolio_id";
        SqlRowSet portfolioResult = jdbcTemplate.queryForRowSet(insertPortfolioSql, gameId, userId, cashBalance);

        if (portfolioResult.next()) {
            int portfolioId = portfolioResult.getInt("portfolio_id");

            String insertStocksSql = "INSERT INTO portfolio_stocks (portfolio_id, stock_ticker) " +
                    "VALUES (?, ?)";
            for (StockModel stock : stocks) {
                jdbcTemplate.update(insertStocksSql, portfolioId, stock.getTicker());
            }

            return getByPortfolioId(portfolioId);
        }

        return null;
    }

    @Override
    public Portfolio updateBuy(Portfolio portfolio, int gameId, int userId) {

        String updatePortfolioSql = "UPDATE portfolio " +
                "SET cash_balance = ? " +
                "WHERE portfolio_id = (SELECT portfolio_id " +
                "FROM portfolio " +
                "WHERE game_id = ? AND user_id = ?)";
        int updatedRows = jdbcTemplate.update(updatePortfolioSql, portfolio.getCashBalance(), gameId, userId);

        if (updatedRows > 0) {

            String insertStocksSql = "INSERT INTO portfolio_stocks (portfolio_id, stock_ticker) " +
                    "VALUES (?, ?)";
            for (StockModel stock : portfolio.getStocks()) {
                jdbcTemplate.update(insertStocksSql, portfolio.getPortfolioId(), stock.getTicker());
            }

            return getByPortfolioId(portfolio.getPortfolioId());
        }

        return null;
    }
    @Override
    public Portfolio updateSell(Portfolio portfolio, int gameId, int userId) {

        String updatePortfolioSql = "UPDATE portfolio " +
                "SET cash_balance = ? " +
                "WHERE portfolio_id = (SELECT portfolio_id " +
                "FROM portfolio " +
                "WHERE game_id = ? AND user_id = ?)";
        int updatedRows = jdbcTemplate.update(updatePortfolioSql, portfolio.getCashBalance(), gameId, userId);

        if (updatedRows > 0) {

            String deleteStocksSql = "DELETE FROM portfolio_stocks " +
                    "WHERE portfolio_id = (SELECT portfolio_id " +
                    "FROM portfolio " +
                    "WHERE game_id = ? AND user_id = ?)";
            jdbcTemplate.update(deleteStocksSql, gameId, userId);

            return getByPortfolioId(portfolio.getPortfolioId());
        }

        return null;
    }


    @Override
    public int delete(int gameId, int userId) {
        return 0;
    }
}
