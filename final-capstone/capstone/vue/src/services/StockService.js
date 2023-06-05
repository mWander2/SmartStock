import axios from "axios";

export default {

    getAllGames() {
        return axios.get("/games")
    },

    createGame(game) {
        return axios.post('/games/new', game)
    },

    getGame(id) {
        return axios.get(`/games/${id}`)
    },

    getPortfolio(gameId) {
        return axios.get(`/portfolios/${gameId}`)
    },

    getPortfolioStocks(gameId) {
        return axios.get(`/portfolios/stocks/${gameId}`)
    },

    buy(stock, cost, gameId) {
        return axios.post(`portfolios/stocks/buy/${cost}/${gameId}`, stock)
    },

    sell(cost, gameId, stockId) {
        return axios.delete(`portfolios/stocks/sell/${cost}/${gameId}/${stockId}`)
    }
    
}